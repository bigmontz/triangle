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

    @Test
    fun testSameSizeSidesIsEquilateral() {
        val triangle = Triangle(BigDecimal(1.5), BigDecimal(1.50), BigDecimal(1.500))
        Assert.assertEquals(TriangleType.EQUILATERAL, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles() {
        val triangle = Triangle(BigDecimal(1.51), BigDecimal(1.6), BigDecimal(1.60))
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles2() {
        val triangle = Triangle(BigDecimal(1.51), BigDecimal(1.51), BigDecimal(1.60))
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testTwoSideWithSameSizeIsIsosceles3() {
        val triangle = Triangle(BigDecimal(1.6), BigDecimal(1.51), BigDecimal(1.60))
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.triangleType)
    }

    @Test
    fun testThreeSidesWithDifferentSizesIsScalene() {
        val triangle = Triangle(BigDecimal(1.55), BigDecimal(1.65), BigDecimal(1.75))
        Assert.assertEquals(TriangleType.SCALENE, triangle.triangleType)
    }

}