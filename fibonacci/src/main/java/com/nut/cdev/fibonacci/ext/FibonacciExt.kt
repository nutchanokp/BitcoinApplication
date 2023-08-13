package com.nut.cdev.fibonacci.ext

import java.math.BigInteger

fun generateFibonacciList(number: Int): MutableList<BigInteger> {
    if (number <= 0) return mutableListOf(BigInteger.ZERO)
    if (number == 1) return mutableListOf(BigInteger.ZERO,BigInteger.ONE)
    var prev = BigInteger.ZERO
    var current = BigInteger.ONE
    val fibonacciList = mutableListOf<BigInteger>(BigInteger.ZERO,BigInteger.ONE)
    for (i in 2 until number) {
        val next = prev + current
        prev = current
        current = next
        fibonacciList.add(next)
    }
    return fibonacciList.toMutableList()
}
fun generateFibonacciAt(index: Int): BigInteger {
    if (index <= 0) return BigInteger.ZERO
    if (index == 1) return BigInteger.ONE
    var prev = BigInteger.ZERO
    var current = BigInteger.ONE
    for (i in 2..index) {
        val next = prev + current
        prev = current
        current = next
    }
    return current
}

fun main(){
    val p = 10000
    val num =  9990

    val length =   (num + p).toString()

    length[0]

}