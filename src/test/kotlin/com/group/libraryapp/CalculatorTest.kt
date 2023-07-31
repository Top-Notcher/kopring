package com.group.libraryapp

import com.group.libraryapp.calculator.Calculator

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
}
class CalculatorTest {

    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        // data class 일 때
        val expectedCalculator = Calculator(8)
        if (calculator != expectedCalculator) {
            throw IllegalStateException()
        }

        // number 가 public 일 떄 -> 수정(백킹 프로퍼티)
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        if (calculator.number != 15) {
            throw IllegalStateException()
        }
    }
}