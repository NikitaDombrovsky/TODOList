package com.example.todolist.core

sealed class Either<out F, out S> {
    data class Failure<out F>(val a: F): Either<F, Nothing>()
    data class Success<out S>(val b: S): Either<Nothing, S>()
    val isFailure get() = this is Failure<F>
    val isSuccess get() = this is Success<S>

    fun <F> failure(a: F) = Failure(a)
    fun <S> success(b: S) = Success(b)
}
fun <F, S, So> Either<F, S>.map(
    success: (S) -> So
): Either<F, So> = when(this){
    is Either.Failure -> Either.Failure(this.a)
    is Either.Success -> Either.Success(success(this.b))
}
/*sealed class Either<out L, out R> {

    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)

    fun <R> right(b: R) = Right(b)
}*/

/*
fun <L, R, Ro> Either<L, R>.map(
    success: (R) -> Ro
): Either<L, Ro> = when (this) {
    is Either.Left -> Either.Left(this.a)
    is Either.Right -> Either.Right(success(this.b))
}*/
