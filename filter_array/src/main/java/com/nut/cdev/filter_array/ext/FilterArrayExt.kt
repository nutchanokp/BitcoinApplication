package com.nut.cdev.filter_array.ext
fun main() {
    val array1 = arrayOf(1, 2, 3, 4, 5)
    val array2 = arrayOf(3, 4, 5, 6, 7)

    val filteredArray = filterArray(array1, array2)

    println("Filtered Array:")
    for (element in filteredArray) {
        println(element)
    }
}

fun filterArray(array1: Array<Int>, array2: Array<Int>): Array<Int> {
    val resultMap = mutableMapOf<Int, Boolean>()

    // สร้างเพิ่มสมาชิกใน resultMap จาก array2
    for (element in array2) {
        resultMap[element] = true
    }

    val filteredList = mutableListOf<Int>()

    // กรองสมาชิกใน array1 โดยใช้ resultMap เพื่อตรวจสอบว่ามีใน array2 หรือไม่
    for (element in array1) {
        if (resultMap.containsKey(element)) {
            filteredList.add(element)
        }
    }

    return filteredList.toTypedArray()
}