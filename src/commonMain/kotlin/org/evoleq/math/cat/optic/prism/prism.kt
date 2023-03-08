/**
 * Copyright (c) 2020 Dr. Florian Schmidt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.evoleq.math.cat.optic.prism

import org.evoleq.math.cat.adt.Either
import org.evoleq.math.cat.adt.Sum.Companion.lift2
import org.evoleq.math.cat.marker.MathCatDsl
import org.evoleq.math.cat.morphism.o

interface Prism<S, T, A, B>{
    val match: (S)->Either<A, T>
    val build: (B)->T
/*
    @MathCatDsl
    infix fun <U> map(f: (T)->U): Prism<S, U, A, B> = Prism(
        match = lift2<A, T, U>(f) o match,
        build = f o build
    )

    @MathCatDsl
    infix fun <R> contraMap(f: (R)->S): Prism<R, T, A, B> = Prism(
        match = match o f,
        build = build
    )

    @MathCatDsl
    fun <R, U> diMap(f: (R)->S, g: (T)->U): Prism<R, U, A, B> = contraMap (f) map g

 */
}

@MathCatDsl
@Suppress("FunctionName")
fun <S, T, A, B> Prism(
    match: (S)->Either<A, T>,
    build: (B)->T
): Prism<S, T, A, B> = object : Prism<S, T, A, B> {
    override val match: (S) -> Either<A, T>
        get() = match
    override val build: (B) -> T
        get() = build
    
}