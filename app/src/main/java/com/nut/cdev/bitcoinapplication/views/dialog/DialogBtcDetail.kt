package com.nut.cdev.bitcoinapplication.views.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.FragmentManager
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseDialogFragment
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.databinding.DialogBtcDetailBinding
import com.nut.cdev.bitcoinapplication.enums.CurrencyEnum
import com.nut.cdev.bitcoinapplication.enums.TopicEnum
import com.nut.cdev.bitcoinapplication.ext.toShowDate
import com.nut.cdev.bitcoinapplication.ext.toShowTime
import java.text.DecimalFormat

@SuppressLint("SetTextI18n")
class DialogBtcDetail() : BaseDialogFragment<DialogBtcDetailBinding>(true) {

    private val TAG = "dialog_btc_detail"
    private var onClick: ((TopicEnum) -> Unit)? = null
    override fun getLayoutId(): Int = R.layout.dialog_btc_detail
    private var btcModel: BtcModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            bg.setOnClickListener { dismiss() }
            val dateTime = btcModel?.time?.updatedISO?.replace("T", " ")?.replace("+00:00", "")
            binding.tvTime.text =
                "Date : " + dateTime?.toShowDate() + "\nTime : " + dateTime?.toShowTime() + " s"
            binding.tvUSD.text = "USD : " + btcModel?.bpi?.USD?.rate
            binding.tvGDP.text = "GBP : " + btcModel?.bpi?.GBP?.rate
            binding.tvEUR.text = "EUR : " + btcModel?.bpi?.EUR?.rate

            etInputNumber.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    tvResultBTC.text = if (btnUSD.isChecked) {
                        CurrencyEnum.USD.convertCurrency(
                            etInputNumber.text.toString().handleValue()
                        )

                    } else if (btnGBP.isChecked) {
                        CurrencyEnum.GBP.convertCurrency(
                            etInputNumber.text.toString().handleValue()
                        )
                    } else {
                        CurrencyEnum.EUR.convertCurrency(
                            etInputNumber.text.toString().handleValue()
                        )
                    }
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
        }
    }

    fun setOnClick(onClick: ((TopicEnum) -> Unit)?) {
        this.onClick = onClick
    }

    companion object {
        const val KEY_BTC = "key_btc"

        fun newInstance(model: BtcModel): DialogBtcDetail {
            val fragment = DialogBtcDetail()
            val bundle = Bundle()
            bundle.putParcelable(KEY_BTC, model)
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun getExtra(bundle: Bundle) {
        super.getExtra(bundle)
        btcModel = arguments?.getParcelable<BtcModel>(KEY_BTC)
    }

    fun CurrencyEnum.convertCurrency(amount: Float): String {
        val result = when (this) {
            CurrencyEnum.USD -> amount / (btcModel?.bpi?.USD?.rate_float ?: 1f)
            CurrencyEnum.GBP -> amount / (btcModel?.bpi?.GBP?.rate_float ?: 1f)
            CurrencyEnum.EUR -> amount / (btcModel?.bpi?.EUR?.rate_float ?: 1f)
        }
        return result.toDouble().formatIVStringDigit() + " BTC"
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }
}


fun Double.formatIVStringDigit(): String {

    val dec = DecimalFormat("#,###.####")
    val sumText = dec.format(this)
    return sumText
}

fun String.handleValue(): Float {

    if (this == " " || this == "."|| this == ""|| this == null) {
        return 0f
    } else {
        return this.toFloat()
    }
}