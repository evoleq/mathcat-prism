package org.evoleq.math.cat.optic.prism

import org.evoleq.math.cat.adt.*
import org.evoleq.math.cat.adt.Sum.Companion.lift1
import org.evoleq.math.cat.adt.Sum.Companion.lift2
import org.evoleq.math.cat.adt.Sum.Companion.multiply
import org.evoleq.math.cat.aux.o

operator fun <S, T, A, B,  U, V> Prism<S, T, A, B>.times(other: Prism<A, B, U, V>): Prism<S, T, U, V> = Prism(
    match = multiply<U, T>() o
            lift1<A, T, Either<U, T>> ( // maps A->Either<U, T> on the first summand
                lift2<U, B, T>(build) o other.match
            ) o
            match,
    build = build o other.build
)