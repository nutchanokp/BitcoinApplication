package com.nut.cdev.prime_number.ext

fun isPrime(number: Int): Boolean {
    if (number <= 1) {
        return false
    }
    if (number <= 3) {
        return true
    }
    if (number % 2 == 0 || number % 3 == 0) {
        return false
    }

    var i = 5
    while (i * i <= number) {
        if (number % i == 0 || number % (i + 2) == 0) {
            return false
        }
        i += 6
    }

    return true
}

fun generatePrimes(n: Int): List<Int> {
    val primeList = mutableListOf<Int>()
    var num = 2
    while (primeList.size < n) {
        if (isPrime(num)) {
            primeList.add(num)
        }
        num++
    }
    return primeList
}

fun main() {
    val n = 100000 // จำนวนจำนวนเฉพาะที่ต้องการสร้าง
    val primeList = generatePrimes(n)

    println("Prime numbers sequence of size $n:")
    primeList.forEach { num ->
        print("$num ")
    }
}