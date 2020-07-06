package org.evoleq.math.cat.prism

import org.evoleq.math.cat.adt.Either

data class Prism<S, T, A, B>(val match: (S)->Either<A, T>,val build: (B)->T)