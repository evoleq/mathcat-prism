package org.evoleq.math.cat.optic.prism

import org.evoleq.math.cat.adt.Left
import org.evoleq.math.cat.adt.Right
import org.evoleq.math.cat.marker.MathCatDsl
import org.evoleq.math.cat.morphism.id

@MathCatDsl
@Suppress("FunctionName")
inline fun <S, reified T: S> SubType(): Prism<S, T, Exception, T>  = Try { s -> require(s is T); s }

@MathCatDsl
@Suppress("FunctionName")
inline fun <reified T> Type(): Prism<Any?, T, Exception, T> = Try { s -> require(s is T); s }

@MathCatDsl
@Suppress("FunctionName")
fun <S, T, B> Try(f: (S)->T, alternative: (B)->T): Prism<S, T, Exception, B> = Prism(
    match ={s ->
        try {
            Right(f(s))
        } catch (exception: Exception) {
            Left(exception)
        }
    },
    build = { alternative(it) }
)


@MathCatDsl
@Suppress("FunctionName")
fun <S, T> Try(f: (S)->T): Prism<S, T, Exception, T> = Try(f, id())