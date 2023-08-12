package com.nut.cdev.validate.ext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nut.cdev.validate.R
import com.nut.cdev.validate.databinding.ActivityValidateBinding

class ValidateActivity : AppCompatActivity() {

    lateinit var binding: ActivityValidateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_validate)
        initView()
    }

    private fun initView() {
        updatePinCode("")
        binding.etPinCode.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                updatePinCode(binding.etPinCode.text.toString())
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun updatePinCode(pinCode: String) {
        binding.apply {
            ivLength.setValidate(pinCode.validatePinCodeLength())
            if (pinCode.validatePinCodeLength()) {
                ivContiguous.setValidate(pinCode.validatePinCodeContiguous())
                ivLinedUp.setValidate(pinCode.validatePinCodeLinedUp())
                ivDuplicate.setValidate(pinCode.validatePinCodeDuplicate())
            } else {
                ivContiguous.setValidate(false)
                ivLinedUp.setValidate(false)
                ivDuplicate.setValidate(false)
            }
        }
    }

    private fun ImageView.setValidate(isValid: Boolean) {
        if (isValid) {
            this.loadImage(R.drawable.baseline_check_circle_outline_24)
        } else {
            this.loadImage(R.drawable.baseline_close_24)
        }
    }

}