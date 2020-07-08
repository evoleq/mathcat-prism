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
package org.evoleq.math.cat.suspend.optic.prism

import kotlinx.coroutines.CoroutineScope
import org.evoleq.math.cat.adt.Either
import org.evoleq.math.cat.marker.MathCatDsl

interface  Prism<S, T, A, B> {
    val match: suspend CoroutineScope.(S) -> Either<A, T>
    val build: suspend CoroutineScope.(B) -> T
}

@MathCatDsl
@Suppress("FunctionName")
fun <S, T, A, B> Prism(
    match: suspend CoroutineScope.(S) -> Either<A, T>,
    build: suspend CoroutineScope.(B) -> T
): Prism<S, T, A, B> = object :Prism<S, T, A, B> {
    override val match: suspend CoroutineScope.(S) -> Either<A, T>
        get() = match
    
    override val build: suspend CoroutineScope.(B) -> T
        get() = build
}