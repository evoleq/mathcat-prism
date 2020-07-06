package org.evoleq.math.cat.suspend.prism

import kotlinx.coroutines.CoroutineScope
import org.evoleq.math.cat.adt.Either

data class Prism<S, T, A, B>(
    val match: suspend CoroutineScope.(S)->Either<A, T>,
    val build: suspend CoroutineScope.(B)->T
)