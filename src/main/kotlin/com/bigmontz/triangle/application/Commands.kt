package com.bigmontz.triangle.application

import com.bigmontz.triangle.domain.Triangle
import org.springframework.beans.factory.annotation.Value
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Class which handles shell commands
 */
@ShellComponent
class Commands (
        @Value("\${bigdecimal.scale}") val scale : Int,
        @Value("\${bigdecimal.roundingMode}") val roundingMode: RoundingMode
    ) {

    /**
     * Command which calculates the triangle type
     * @param a The a side
     * @param b The b side
     * @param c The c side
     */
    @ShellMethod("Tells the triangle type")
    fun triangleType(a: BigDecimal, b : BigDecimal, c : BigDecimal) {
        val triangle = Triangle(scaleIt(a), scaleIt(b), scaleIt(c))
        println("The Triangle ($a, $b, $c) is ${triangle.type}")
    }

    /**
     * Receives an BigDecimal and Scale It
     *
     * @param value The value which will be scaled
     * @return The value scaled
     */
    private fun scaleIt(value : BigDecimal) : BigDecimal {
        return value.setScale(scale, roundingMode)
    }
}
