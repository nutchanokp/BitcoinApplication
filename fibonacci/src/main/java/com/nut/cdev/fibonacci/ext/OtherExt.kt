package com.nut.cdev.fibonacci.ext


enum class RuleEnum {
    I, II, III, IV
}

private fun RuleEnum.handleNumber(number : Int): Int {
    val plusNum = 10000
    val length = (((number ?: 1) + plusNum)).toString()

    return when (this) {
        RuleEnum.I -> length.substring(1, 2).toInt()
        RuleEnum.II -> length.substring(2, 3).toInt()
        RuleEnum.III -> length.substring(3, 4).toInt()
        RuleEnum.IV -> length.substring(4, 5).toInt()
    }
}
