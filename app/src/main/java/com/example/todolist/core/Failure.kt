package com.example.todolist.core

sealed class Failure {
    object ConnectionError : Failure()
    object UnexpectedError : Failure()
    object NoDataError : Failure()

    data class Error(val message: String) : Failure()
}