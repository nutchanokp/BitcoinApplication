package com.nut.cdev.bitcoinapplication.views.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseDialogFragment
import com.nut.cdev.bitcoinapplication.databinding.DialogAlertMessageBinding

class DialogAlertMessage : BaseDialogFragment<DialogAlertMessageBinding>(false) {

    private val TAG = "dialog_alert_message"

    //    private lateinit var binding: DialogAlertMessageBinding
    private var onLeftClick: ((DialogFragment) -> Unit)? = null
    private var onRightClick: ((DialogFragment) -> Unit)? = null
    private var type: Int? = null
    var isDismiss: Boolean = true

    companion object {
        const val KEY_TITLE = "key_title"
        const val KEY_MESSAGE = "key_message"
        const val KEY_TEXT_BUTTON_LEFT = "key_text_button_left"
        const val KEY_TEXT_BUTTON_RIGHT = "key_text_button_right"
        const val KEY_FOCUS_LEFT = "key_focus_left"
        const val KEY_FOCUS_RIGHT = "key_focus_right"
        const val KEY_TYPE = "key_type"
        const val KEY_MESSAGE_GRAVITY = "key_message_gravity"

        fun newInstance(message: String, msgGravity: Int = Gravity.CENTER): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, "OK")
            bundle.putBoolean(KEY_FOCUS_LEFT, true)
            bundle.putInt(KEY_MESSAGE_GRAVITY, msgGravity)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstanceWithTitle(title: String, message: String): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TITLE, title)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, "OK")
            bundle.putBoolean(KEY_FOCUS_LEFT, true)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance(message: String, nameButton: String): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, nameButton)
            bundle.putBoolean(KEY_FOCUS_LEFT, true)
            bundle.putInt(KEY_MESSAGE_GRAVITY, Gravity.CENTER)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstanceErrorMessage(
            title: String,
            message: String,
            nameButton: String
        ): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_TITLE, title)
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, nameButton)
            bundle.putBoolean(KEY_FOCUS_LEFT, true)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance(
            message: String,
            textLeft: String?,
            textRight: String?,
            msgGravity: Int = Gravity.CENTER
        ): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, textLeft)
            bundle.putString(KEY_TEXT_BUTTON_RIGHT, textRight)
            bundle.putInt(KEY_MESSAGE_GRAVITY, msgGravity)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstanceWithOk(message: String, textRight: String, type: Int): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_MESSAGE, message)
            bundle.putInt(KEY_TYPE, type)
            bundle.putString(KEY_TEXT_BUTTON_RIGHT, textRight)
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance(
            title: String,
            message: String,
            textLeft: String, focusLeft: Boolean,
            textRight: String, focusRight: Boolean
        ): DialogAlertMessage {
            val fragment = DialogAlertMessage()
            val bundle = Bundle()
            bundle.putString(KEY_TITLE, title)
            bundle.putString(KEY_MESSAGE, message)
            bundle.putString(KEY_TEXT_BUTTON_LEFT, textLeft)
            bundle.putString(KEY_TEXT_BUTTON_RIGHT, textRight)
            bundle.putBoolean(KEY_FOCUS_LEFT, focusLeft)
            bundle.putBoolean(KEY_FOCUS_RIGHT, focusRight)
            bundle.putInt(KEY_MESSAGE_GRAVITY, Gravity.CENTER)
            fragment.arguments = bundle
            return fragment
        }
    }


    var focusLeft: Boolean = true
        set(value) {
            context?.let { context ->
                if (value) {
//                    val fontMedium = ResourcesCompat.getFont(context, R.font.kanit_medium)
                    binding.tvLeft.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
//                    binding.tvLeft.typeface = fontMedium
                    binding.tvLeft.setBackgroundResource(R.color.color_true_blue)
                } else {
//                    val fontRegular = ResourcesCompat.getFont(context, R.font.kanit_regular)
                    binding.tvRight.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
                    binding.tvLeft.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.ultramarine_blue
                        )
                    )
                    binding.tvLeft.setBackgroundResource(R.color.alice_blue)
                }
                field = value
            }
        }

    var focusRight: Boolean = true
        set(value) {
            context?.let { context ->
                if (value) {
//                    val fontMedium = ResourcesCompat.getFont(context, R.font.kanit_medium)
                    binding.tvRight.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
//                    binding.tvRight.typeface = fontMedium
                    binding.tvRight.setBackgroundResource(R.color.color_true_blue)
                } else {
//                    val fontRegular = ResourcesCompat.getFont(context, R.font.kanit_regular)
                    binding.tvRight.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
//                    binding.tvRight.typeface = fontRegular
                    binding.tvRight.setBackgroundResource(R.color.united_nations_blue)
                }
                field = value
            }
        }

    var textMessage: String? = null
        set(value) {
            if (value.isNullOrEmpty()) return
            binding.tvMessage.text = value
            field = value
        }

    var msgGravity = Gravity.CENTER
        set(value) {
            binding.tvMessage.gravity = value
            field = value
        }

    var textButtonLeft: String? = null
        set(value) {
            if (value.isNullOrEmpty()) {
                binding.tvLeft.visibility = View.GONE
            } else {
                binding.tvLeft.visibility = View.VISIBLE
                binding.tvLeft.text = value
            }
            field = value
        }

    var textButtonRight: String? = null
        set(value) {
            if (value.isNullOrEmpty()) {
                binding.tvRight.visibility = View.GONE
            } else {
                binding.tvRight.visibility = View.VISIBLE
                binding.tvRight.text = value
            }
            field = value
        }

    var textTitle: String? = null
        set(value) {
            if (value.isNullOrEmpty()) {
                binding.tvTitle.visibility = View.GONE
            } else {
                binding.tvTitle.visibility = View.VISIBLE
                binding.tvTitle.text = value
            }
            field = value
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_alert_message,
            null,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    override fun getLayoutId(): Int = R.layout.dialog_alert_message


    private fun initView() {
        arguments?.let {
            val message = it.getString(KEY_MESSAGE)
            val textLeft = it.getString(KEY_TEXT_BUTTON_LEFT)
            val textRight = it.getString(KEY_TEXT_BUTTON_RIGHT)
            val textTitle = it.getString(KEY_TITLE)
            type = it.getInt(KEY_TYPE)
            val focusLeft = it.getBoolean(KEY_FOCUS_LEFT)
            val focusRight = it.getBoolean(KEY_FOCUS_RIGHT)
            this.msgGravity = it.getInt(KEY_MESSAGE_GRAVITY)
            this.textMessage = message
            this.textButtonLeft = textLeft
            this.focusLeft = focusLeft
            this.textButtonRight = textRight
            this.focusRight = focusRight
            this.textTitle = textTitle
        }

    }

    private fun initListener() {
        binding.tvLeft.setOnClickListener {
            if (isDismiss) dismiss()
            onLeftClick?.invoke(this)
        }
        binding.tvRight.setOnClickListener {
            if (isDismiss) dismiss()
            onRightClick?.invoke(this)
        }
    }


    fun setOnButtonRightClick(onRightClick: ((DialogFragment) -> Unit)?) {
        this.onRightClick = onRightClick
    }

    fun setOnButtonLeftClick(onLeftClick: ((DialogFragment) -> Unit)?) {
        this.onLeftClick = onLeftClick
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }


}