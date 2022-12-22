package dev.iamwami.app.quotinews.util

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    coroutineDispatcher: CoroutineDispatcher,
    apiCallFunction: suspend () -> T,
    shouldApiCallBeRetried: Boolean = false,
    maximumRetries: Int = 10,
    apiCallDelayedBy: Long = 3000
): ResultWrapper<T> {
    return withContext(coroutineDispatcher) {
        var count = if (shouldApiCallBeRetried) maximumRetries else 1
        var response: ResultWrapper<T> = ResultWrapper.Loading(data = null, message = "api call is loading")

        while (count > 0) {

            try {
                response = ResultWrapper.Success(data = apiCallFunction.invoke(), code = 200, message = "api call was successful")
                return@withContext response // break out of loop on success
            } catch (throwable: Throwable) {
                Log.d("testing", "catch an error $throwable")
                response = when (throwable) {

                    is IOException -> ResultWrapper.Error<T>(code = null, message = throwable.toString())
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse: ResponseBody? = throwable.response()?.errorBody()
                        val errorMessage: String = errorResponse?.toString()
                            ?: "UNKNOWN HTTP Error response body was null."
                        ResultWrapper.Error<T>(message = errorMessage, code = code)
                    }
                    else -> {
                        ResultWrapper.Error<T>(code = null, message = throwable.toString())
                    }
                }
                delay(apiCallDelayedBy)
                count--
            }
        }
        response
    }
}