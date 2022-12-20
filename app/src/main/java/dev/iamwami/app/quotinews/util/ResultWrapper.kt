package dev.iamwami.app.quotinews.util

sealed class ResultWrapper<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null
) {
    class Success<T>(data: T? = null, code: Int? = null) : ResultWrapper<T>(data = data, code = code)
    class Error<T>(message: String? = null, code: Int? = null) : ResultWrapper<T>(message = message, code = code)
    class Loading<T>(data: T? = null) : ResultWrapper<T>(data = data)

//    fun <T> testON(data: T, code: Int? = null): ResultWrapper<T> {
//        return ResultWrapper("Status.SUCCESS", data, null, code)
//    }
}