package com.nut.cdev.bitcoinapplication.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.nut.cdev.bitcoinapplication.R

abstract class BaseDialogFragment<B : ViewDataBinding>(
    private var isCanBack: Boolean = true,
    private var isSlideAnimation: Boolean = false
) : DialogFragment() {

    protected lateinit var binding: B
    var isShow: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            if (isSlideAnimation) {
                attributes?.windowAnimations = R.style.DialogAnimation
            }
        }
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            getExtra(it)
        }

        setUp()
        listener()
        subscribe()

    }

    override fun onStart() {
        super.onStart()

        dialog.let {
            it?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            it?.setCancelable(isCanBack)
        }
    }

    abstract fun getLayoutId(): Int

    open fun getExtra(bundle: Bundle) {}

    open fun setUp() {}

    open fun listener() {}

    open fun subscribe() {}

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
        isShow = true
    }

    override fun dismiss() {
        try {
            if (isShow) {
                super.dismiss()
                isShow = false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setIsCancelable(isCanBack: Boolean) {
        dialog.let {
            it?.setCanceledOnTouchOutside(isCanBack)
        }

    }
}