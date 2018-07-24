package com.bigmontz.triangle.domain

import java.math.BigDecimal

/**
 * Represents a Triangle
 */
class Triangle(val a : BigDecimal, val b : BigDecimal, val c : BigDecimal) {
    val triangleType = if ( a == b && b == c ) TriangleType.EQUILATERAL
        else if ( a == b || b == c || a == c ) TriangleType.ISOSCELES
        else TriangleType.SCALENE

}