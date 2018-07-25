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
        Assert.assertEquals(TriangleType.EQUILATERAL, triangle.type)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles() {
        val triangle = Triangle(a, b, b)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.type)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles2() {
        val triangle = Triangle(a, a, b)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.type)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles3() {
        val triangle = Triangle(a, b, a)
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.type)
    }

    @Test
    fun testThreeSidesWithDifferentSizesIsScalene() {
        val triangle = Triangle(a, b, c)
        Assert.assertEquals(TriangleType.SCALENE, triangle.type)
    }

    @Test
    fun testASideGreaterThanBPlusCIsNotAValidTriangle() {
        val triangle = Triangle(hugeValue, b, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testBSideGreaterThanCPlusAIsNotAValidTriangle() {
        val triangle = Triangle(a, hugeValue, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testCSideGreaterThanAPlusBIsNotAValidTriangle() {
        val triangle = Triangle(a, b, hugeValue)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testNegativeASideIsAnInvalidTriangle() {
        val  triangle = Triangle(a.negate(), b, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testNegativeBSideIsAnInvalidTriangle() {
        val triangle = Triangle(a, b.negate(), c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testNegativeCSideIsAnInvalidTriangle() {
        val triangle = Triangle(a, b, c.negate())
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testNegativeSidesIsAnInvalidTriangle() {
        val triangle = Triangle(a.negate(), b.negate(), c.negate())
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testAPlusBEqualsCIsAnInvalidTringle() {
        val triangle = Triangle(a, b, a.plus(b))
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testBPlusCEqualsAIsAnInvalidTriangle() {
        val triangle = Triangle(b.plus(c), b, c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }

    @Test
    fun testAPlusCEqualsBIsAnInvalidTriangle() {
        val triangle = Triangle(a, a.plus(c), c)
        Assert.assertEquals(TriangleType.INVALID, triangle.type)
    }
}