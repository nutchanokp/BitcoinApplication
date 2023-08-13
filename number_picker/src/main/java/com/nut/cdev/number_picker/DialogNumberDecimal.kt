package com.nut.cdev.number_picker

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.nut.cdev.number_picker.databinding.DialogChooseNumberDecimalBinding

class DialogNumberDecimal : BaseDialogFragment<DialogChooseNumberDecimalBinding>(true) {

    private val TAG = "dialog_number_decimal"

    private var callback: ((Int) -> Unit)? = null
    private var numberPickerModel: NumberPickerModel = NumberPickerModel()
    private var summary: Int = 0
    private var numberI: Int = 0
    private var numberII: Int = 0
    private var numberIII: Int = 0
    override fun getLayoutId(): Int = R.layout.dialog_choose_number_decimal


    companion object {
        const val KEY_NUMBER_PICKER = "key_number_picker"
        fun newInstance(numberPickerModel: NumberPickerModel): DialogNumberDecimal {
            val fragment = DialogNumberDecimal()
            val bundle = Bundle()
            bundle.putParcelable(KEY_NUMBER_PICKER, numberPickerModel)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            numberPickerModel =
                it.parcelable<NumberPickerModel>(KEY_NUMBER_PICKER) ?: NumberPickerModel()
            binding.apply {
                tvTitle.text = numberPickerModel.title
                tvUnit.text = numberPickerModel.tUnit
            }
        }
        setupNumberPickerI()
        setupNumberPickerII()
        setupNumberPickerIII()

        binding.btnSubmit.setOnClickListener {
            summary =
                (numberI.toString() + numberII.toString() + numberIII.toString() ).toInt()
            callback?.invoke(summary)
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun setupNumberPickerI() {
        val numberPicker = binding.numberPickerI
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            numberPicker.minValue = 0
            numberPicker.maxValue = 9
            numberPicker.wrapSelectorWheel = true
            numberPicker.value = RuleEnum.I.handleNumber()
            numberI = RuleEnum.I.handleNumber()
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
//            val text = "Changed from $oldVal to $newVal"
//            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
                numberI = newVal
            }
        }

    }

    private fun setupNumberPickerII() {
        val numberPicker = binding.numberPickerII
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            numberPicker.minValue = 0
            numberPicker.maxValue = 9
            numberPicker.wrapSelectorWheel = true
            numberPicker.value = RuleEnum.II.handleNumber()
            numberII = RuleEnum.II.handleNumber()
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
//            val text = "Changed from $oldVal to $newVal"
//            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
                numberII = newVal
            }
        }

    }

    private fun setupNumberPickerIII() {
        val numberPicker = binding.numberPickerIII
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            numberPicker.minValue = 0
            numberPicker.maxValue = 9
            numberPicker.wrapSelectorWheel = true
            numberPicker.value = RuleEnum.III.handleNumber()
            numberIII = RuleEnum.III.handleNumber()
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
//            val text = "Changed from $oldVal to $newVal"
//            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
                numberIII = newVal
            }
        }

    }

    enum class RuleEnum {
        I, II, III
    }

    private fun RuleEnum.handleNumber(): Int {
        val plusNum = 1000
        val length = (((numberPickerModel.default ?: 1) + plusNum)).toString()

        return when (this) {
            RuleEnum.I -> length.substring(1, 2).toInt()
            RuleEnum.II -> length.substring(2, 3).toInt()
            RuleEnum.III -> length.substring(3, 4).toInt()
        }
    }

    fun onSelectHeight(callback: ((Int) -> Unit)?) {
        this.callback = callback
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }
}