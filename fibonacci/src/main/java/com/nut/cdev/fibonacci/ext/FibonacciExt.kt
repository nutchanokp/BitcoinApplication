package com.nut.cdev.fibonacci.ext

fun generateFibonacci(n: Int): List<Int> {
    val fibonacciList = mutableListOf(0, 1)
    while (fibonacciList.size < n) {
        val nextFibonacci = fibonacciList[fibonacciList.size - 1] + fibonacciList[fibonacciList.size - 2]
        fibonacciList.add(nextFibonacci)
    }
    return fibonacciList
}

fun main() {
    val n = 10 // จำนวนตัวเลข Fibonacci ที่ต้องการสร้าง
    val fibonacciList = generateFibonacci(n)

    println("Fibonacci sequence of size $n:")
    fibonacciList.forEach { num ->
        print("$num ")
    }
}