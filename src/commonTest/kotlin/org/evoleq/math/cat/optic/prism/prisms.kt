package org.evoleq.math.cat.optic.prism

import org.evoleq.math.cat.adt.Left
import org.evoleq.math.cat.adt.Right
import org.evoleq.math.cat.adt.Sum
import kotlin.test.Test
import kotlin.test.assertTrue

class PrismsTest {
    @Test
    fun type() {
        val x = 1
        val s = ""
        val n = null

        assertTrue { Type<Int>().match(x) is Right }
        assertTrue { Type<Int>().match(s) is Left }
        assertTrue { Type<Int>().match(n) is Left }
    }


    @Test
    fun subType() {

        val x : Sub1 = object : Sub1 {}

        assertTrue { SubType<Super, Sub1>().match(x) is Right }
        assertTrue { SubType<Super, Sub2>().match(x) is Left }


    }
}

interface Super
interface Sub1 : Super
interface Sub2 : Super

