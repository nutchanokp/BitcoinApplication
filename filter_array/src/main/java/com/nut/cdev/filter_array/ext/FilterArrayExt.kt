package com.nut.cdev.filter_array.ext
fun main() {
    val array1 = arrayOf(1, 2, 3, 4, 5,10,9,33,55,20)
    val array2 = arrayOf(33,3, 4, 5,55, 6, 7)

    val filteredArray = filterArray(array1, array2)

    println("Filtered Array:")
    for (element in filteredArray) {
        println(element)
    }
}

fun filterArray(array1: Array<Int>, array2: Array<Int>): Array<Int> {
    val filteredArray = mutableListOf<Int>()

    for (item1 in array1) {
        for (item2 in array2) {
            if (item1 == item2) {
                filteredArray.add(item1)
                break
            }
        }
    }

    val result = filteredArray.toTypedArray()

    return result
}