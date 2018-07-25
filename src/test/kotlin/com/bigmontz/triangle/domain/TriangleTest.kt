package com.bigmontz.triangle.domain

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal

/**
 * Test class for Triangle
 */
@RunWith(SpringRunner::class)
class TriangleTest {
    private val a = BigDecimal(1.5)
    private val aa = BigDecimal(1.50)
    private val aaa = BigDecimal(1.500)
    private val b = BigDecimal(1.60)
    private val c = BigDecimal(1.61)
    private val hugeValue = a.plus(b).plus(c);

    @Test
    fun testSameSizeSidesIsEquilateral() {
        val triangle = Triangle(a, aa, aaa)
        Assert.assertEquals(TriangleType.EQUILATERAL, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles() {
        val triangle = Triangle(a, b, b)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles2() {
        val triangle = Triangle(a, a, b)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles3() {
        val triangle = Triangle(a, b, a)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testThreeSidesWithDifferentSizesIsScalene() {
        val triangle = Triangle(a, b, c)
        Assert.assertEquals(TriangleType.SCALENE, triangle.triangleType)
    }

    @Test
    fun testASideGreaterThanBPlusCIsNotAValidTriangle() {
        val triangle = Triangle(hugeValue, b, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.triangleType)
    }

    @Test
    fun testBSideGreaterThanCPlusAIsNotAValidTriangle() {
        val triangle = Triangle(a, hugeValue, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.triangleType)
    }

    @Test
    fun testCSideGreaterThanAPlusBIsNotAValidTriangle() {
        val triangle = Triangle(a, b, hugeValue)
        Assert.assertEquals(TriangleType.INVALID, triangle.triangleType)
    }

}