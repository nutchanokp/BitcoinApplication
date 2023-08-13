package com.nut.cdev.validate.ext

import org.junit.Assert.*

import org.junit.Test

class ValidateExtKtTest {

    @Test
    fun validatePincode() {

        val pin1 = "17283"  // return False
        val pin2 = "172839"  // return True
        val pin3 = "111822"  // return False
        val pin4 = "112762"  // return True
        val pin5 = "123743"  // return False
        val pin6 = "321895"  // return False
        val pin7 = "124578"  // return True
        val pin8 = "112233"  // return False
        val pin9 = "882211"  // return False
        val pin10 = "887712"  // return True

        assertFalse(validatePincode(pin1))
        assertTrue(validatePincode(pin2))
        assertFalse(validatePincode(pin3))
        assertTrue(validatePincode(pin4))
        assertFalse(validatePincode(pin5))
        assertFalse(validatePincode(pin6))
        assertTrue(validatePincode(pin7))
        assertFalse(validatePincode(pin8))
        assertFalse(validatePincode(pin9))
        assertTrue(validatePincode(pin10))
    }

    @Test
    fun validatePinCodeLength() {
        val pin1 = "17283"  // return False
        val pin2 = "172839"  // return True

        assertFalse(pin1.validatePinCodeLength())
        assertTrue(pin2.validatePinCodeLength())
    }

    @Test
    fun validatePinCodeContiguous() {
        val pin3 = "111822"  // return False
        val pin4 = "112762"  // return True

        assertFalse(pin3.validatePinCodeContiguous())
        assertTrue(pin4.validatePinCodeContiguous())
    }

    @Test
    fun validatePinCodeLinedUp() {
        val pin5 = "123743"  // return False
        val pin6 = "321895"  // return False
        val pin7 = "124578"  // return True

        assertFalse(pin5.validatePinCodeLinedUp())
        assertFalse(pin6.validatePinCodeLinedUp())
        assertTrue(pin7.validatePinCodeLinedUp())
    }

    @Test
    fun validatePinCodeDuplicate() {
        val pin8 = "112233"  // return False
        val pin9 = "882211"  // return False
        val pin10 = "887712"  // return True

        assertFalse(pin8.validatePinCodeDuplicate())
        assertFalse(pin9.validatePinCodeDuplicate())
        assertTrue(pin10.validatePinCodeDuplicate())
    }
}