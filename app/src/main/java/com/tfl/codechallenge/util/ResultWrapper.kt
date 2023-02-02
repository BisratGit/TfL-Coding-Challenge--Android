package com.tfl.codechallenge.util


data class ResultWrapper<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val code: Int? = null
) {

    companion object {

        fun <T> success(data: T?): ResultWrapper<T> {
            return ResultWrapper(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, errorCode: Int?, data: T?): ResultWrapper<T> {
            return ResultWrapper(Status.ERROR, data, message, errorCode)
        }

        fun <T> loading(data: T?): ResultWrapper<T> {
            return ResultWrapper(Status.LOADING, data, null)
        }

    }

}


/*
data class StateWrapper<out T>(val status: Status, val data: T?, val msg: String?, val code: Int?){
    companion object{
        fun <T> success(data: T?): StateWrapper<T>{
            return StateWrapper(Status.SUCCESS, data, null, null)
        }

        fun<T> error(msg: String?, code: Int?, data: T? = null): StateWrapper<T>{
            Log.i("Debug", "Data: $data Code: $code")
            return StateWrapper(Status.ERROR, data, msg, code)
        }

        fun <T> loading(data: T? = null): StateWrapper<T>{
            return StateWrapper(Status.LOADING, data, null, null)
        }
    }
}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING
}*/
