package com.nut.cdev.bitcoinapplication.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.bitcoinapplication.views.main.MainActivity
import com.nut.cdev.fibonacci.FibonacciActivity
import com.nut.cdev.prime_number.PrimeNumberActivity
import com.nut.cdev.validate.ext.ValidateActivity

class MainRouter constructor(
    val activity: AppCompatActivity
) {

    fun toMain() {
        val intent = Intent(activity, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        activity.apply {
            startActivity(intent)
//            TransitionUtils().showActivityTransitionFromTop(activity)
        }
    }

    fun toBMI() {
        activity.apply {
//            startActivity(Intent(activity, BMIActivity::class.java))
        }
    }

    fun toFibonacci() {
        activity.apply {
            startActivity(Intent(activity, FibonacciActivity::class.java))
        }
    }
    fun toPrimeNumber() {
        activity.apply {
            startActivity(Intent(activity, PrimeNumberActivity::class.java))
        }
    }
    fun toValidatePinCode() {
        activity.apply {
            startActivity(Intent(activity, ValidateActivity::class.java))
        }
    }

}
