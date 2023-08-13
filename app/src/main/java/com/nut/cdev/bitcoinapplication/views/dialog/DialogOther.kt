package com.nut.cdev.bitcoinapplication.views.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseDialogFragment
import com.nut.cdev.bitcoinapplication.databinding.DialogOtherBinding
import com.nut.cdev.bitcoinapplication.enums.TopicEnum
import com.nut.cdev.bitcoinapplication.router.MainRouter

class DialogOther() : BaseDialogFragment<DialogOtherBinding>(true) {

    private var onClick: ((TopicEnum) -> Unit)? = null
    override fun getLayoutId(): Int = R.layout.dialog_other

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            bg.setOnClickListener { dismiss() }
            btnFibonacci.setOnClickListener {
                onClick?.invoke(TopicEnum.fibonacci)
            }
            btnFilterArray.setOnClickListener {
                onClick?.invoke(TopicEnum.filter_array)
            }
            btnPickerNumber.setOnClickListener {
                onClick?.invoke(TopicEnum.prime_number)
            }
            btnValidate.setOnClickListener {
                onClick?.invoke(TopicEnum.validate)
            }
        }
    }

    fun setOnClick(onClick: ((TopicEnum) -> Unit)?) {
        this.onClick = onClick
    }
}