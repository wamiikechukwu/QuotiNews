package dev.iamwami.app.quotinews.util

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import kotlin.coroutines.startCoroutine

suspend fun <T> SafeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T,
    retry: Boolean = false,
    retry_max: Int = 10,
    retry_delay: Long = 3000
): ResultWrapper<T> {
    return withContext(dispatcher) {
        var count = if (retry) retry_max else 1
        var response: ResultWrapper<T> = ResultWrapper.Loading(data = null)
//        TODO set log to see that the response will return

        while (count > 0) {

            try {
                Log.d("testing", "calling sus func $apiCall")
                response = ResultWrapper.Success(apiCall.invoke())
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
                delay(retry_delay)
                count--
            }

        }
        response
    }
}