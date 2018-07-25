package com.bigmontz.triangle.application

import com.bigmontz.triangle.domain.Triangle
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import java.math.BigDecimal
import java.math.RoundingMode

@ShellComponent
class Commands {

    private val defaultScale = 120
    private val roundingMode = RoundingMode.HALF_UP

    @ShellMethod("Tells the triangle type")
    fun triangle(a: BigDecimal, b : BigDecimal, c : BigDecimal) {
        val triangle = Triangle(scaleIt(a), scaleIt(b), scaleIt(c))
        println("The Triangle ($a, $b, $c) is ${triangle.type}")
    }

    private fun scaleIt(value : BigDecimal) : BigDecimal {
        return value.setScale(defaultScale, roundingMode)
    }
}
