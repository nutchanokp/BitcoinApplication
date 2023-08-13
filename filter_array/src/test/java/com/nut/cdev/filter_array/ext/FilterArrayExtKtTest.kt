package com.nut.cdev.filter_array.ext

import org.junit.Assert.*

import org.junit.Test

class FilterArrayExtKtTest {
    @Test
    fun filterArray() {
        val array1 = arrayOf(1, 2, 3, 4, 5)
        val array2 = arrayOf(3, 4, 5, 6, 7)

        val result = arrayOf(3, 4, 5)

        val filteredArray = filterArray(array1, array2)

        assertArrayEquals(filteredArray,result)
    }
}