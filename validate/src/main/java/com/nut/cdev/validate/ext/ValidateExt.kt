package com.nut.cdev.validate.ext

fun validatePincode(pin: String): Boolean {
    var result = true
    // เช็คความยาวของ input
    result = pin.validatePinCodeLength()
    // เช็คเลขซ้ำติดกันเกิน 2 ตัว
    result = if (result) pin.validatePinCodeContiguous() else result
    // เช็คเลขเรียงกันเกิน 2 ตัว
    result = if (result) pin.validatePinCodeLinedUp() else result
    // เช็คเลขชุดซ้ำเกิน 2 ชุด
    result = if (result) pin.validatePinCodeDuplicate() else result

    return result
}

// เช็คความยาวของ input
fun String.validatePinCodeLength(): Boolean {
    return this.length >= 6
}

// เช็คเลขซ้ำติดกันเกิน 2 ตัว
fun String.validatePinCodeContiguous(): Boolean {
    for (i in 0 until this.length - 2) {
        if (this[i] == this[i + 1] && this[i + 1] == this[i + 2]) {
            return false
        }
    }
    return true
}

// เช็คเลขเรียงกันเกิน 2 ตัว
fun String.validatePinCodeLinedUp(): Boolean {
    for (i in 0..this.length - 3) {
        if (this[i].code - this[i + 1].code == 1 && this[i + 1].code - this[i + 2].code == 1) {
            return false
        } else if (this[i].code - this[i + 1].code == -1 && this[i + 1].code - this[i + 2].code == -1) {
            return false
        }
    }
    return true
}

// เช็คเลขชุดซ้ำเกิน 2 ชุด
fun String.validatePinCodeDuplicate(): Boolean {
    val pattern = "(\\d)\\1.*(\\d)\\2".toRegex()
    if (pattern.matches(this)) {
        return false
    }
    return true
}

fun main() {
    val pin1 = "17283"
    val pin2 = "172839"
    val pin3 = "111822"
    val pin4 = "112762"
    val pin5 = "123743"
    val pin6 = "321895"
    val pin7 = "124578"
    val pin8 = "112233"
    val pin9 = "882211"
    val pin10 = "887712"

    println("Pincode $pin1 is valid: ${validatePincode(pin1)}")
    println("Pincode $pin2 is valid: ${validatePincode(pin2)}")
    println("Pincode $pin3 is valid: ${validatePincode(pin3)}")
    println("Pincode $pin4 is valid: ${validatePincode(pin4)}")
    println("Pincode $pin5 is valid: ${validatePincode(pin5)}")
    println("Pincode $pin6 is valid: ${validatePincode(pin6)}")
    println("Pincode $pin7 is valid: ${validatePincode(pin7)}")
    println("Pincode $pin8 is valid: ${validatePincode(pin8)}")
    println("Pincode $pin9 is valid: ${validatePincode(pin9)}")
    println("Pincode $pin10 is valid: ${validatePincode(pin10)}")
}