package com.bigmontz.triangle.domain

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Represents a Triangle
 */
class Triangle(val a : BigDecimal, val b : BigDecimal, val c : BigDecimal) {
    
    val type = if (isInvalid()) TriangleType.INVALID
        else if ( a == b && b == c ) TriangleType.EQUILATERAL
        else if ( a == b || b == c || a == c ) TriangleType.ISOSCELES
        else TriangleType.SCALENE

    private fun isInvalid() : Boolean {
        return b.plus(c) <= a || a.plus(b) <= c || a.plus(c) <= b
    }
}