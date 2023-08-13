package com.nut.cdev.prime_number.ext

import org.junit.Assert.*

import org.junit.Test

class PrimeNumberExtKtTest {

    @Test
    fun testIsPrimeNumber() {
        val primeNumber = arrayListOf<Int>(2, 3, 5, 7, 11, 13, 17, 19)
        primeNumber.forEach {
            assertTrue(isPrime(it))
        }
        val notPrimeNumber = arrayListOf<Int>(0, 1,4, 6, 8, 9, 10, 12)
        notPrimeNumber.forEach {
            assertFalse(isPrime(it))
        }
    }

    @Test
    fun testGeneratePrimes() {
        val result = arrayListOf<Int>(2, 3, 5, 7, 11, 13, 17, 19)

        assertEquals(generatePrimes(8), result)
    }
}