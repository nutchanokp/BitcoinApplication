package com.nut.cdev.bitcoinapplication.views.main

import android.annotation.SuppressLint
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseActivity
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import com.nut.cdev.bitcoinapplication.databinding.ActivityMainBinding
import com.nut.cdev.bitcoinapplication.enums.TopicEnum
import com.nut.cdev.bitcoinapplication.ext.enableSwipeRecyclerView
import com.nut.cdev.bitcoinapplication.ext.toShowDate
import com.nut.cdev.bitcoinapplication.ext.toShowTime
import com.nut.cdev.bitcoinapplication.views.dialog.DialogAlertMessage
import com.nut.cdev.bitcoinapplication.views.dialog.DialogBtcDetail
import com.nut.cdev.bitcoinapplication.views.dialog.DialogOther
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("SetTextI18n")
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    private val viewModel: MainViewModel by viewModel()

    private val adapter = HistoryAdapter()
    override fun initView() {
        binding.rvHistory.adapter = adapter


    }

    override fun initInstances() {
        binding.apply {
            btnMenu.setOnClickListener { showDialogOther() }
            adapter.selectMenu { showDialogDetail(it.toBtcModel()) }
            btnNewBtc.setOnClickListener { showDialogDetail() }
            rvHistory.enableSwipeRecyclerView(
                this@MainActivity,
                adapter
            ) { btc -> showDialogAlertMessage(btc) }
        }
    }

    private fun showDialogAlertMessage(btc: BtcHistoryModel) {

        val dialog = DialogAlertMessage.newInstance("คุณต้องการลบหรือไม่", "ใช่", "ไม่")
        dialog.setOnButtonLeftClick {
            runBlocking {
                btc.updatedISO?.let { it1 -> viewModel.deleteHistory(it1) }
            }
        }
        dialog.setOnButtonRightClick { }
        dialog.show(supportFragmentManager)

    }

    override fun setupObserve() {

        viewModel.btc.observe(this) {
            val dateTime = it.body()?.time?.updatedISO?.replace("T", " ")?.replace("+00:00", "")
            binding.tvTime.text =
                "Date : " + dateTime?.toShowDate() + "\nTime : " + dateTime?.toShowTime() + " s"
            binding.tvUSD.text = "USD : " + it.body()?.bpi?.USD?.rate
            binding.tvGDP.text = "GBP : " + it.body()?.bpi?.GBP?.rate
            binding.tvEUR.text = "EUR : " + it.body()?.bpi?.EUR?.rate

        }
        viewModel.btcHistory.observe(this) {
            it.let { it1 -> adapter.setItems(it1.toMutableList()) }

        }
        viewModel.countDownTimer.observe(this) {
            binding.tvCountdown.text = it
        }


    }

    private fun showDialogDetail(btcModel: BtcModel? = null) {
        val dialog = if (btcModel != null) {
            DialogBtcDetail.newInstance(btcModel)
        } else {
            viewModel.getCurrentBtc()?.let { DialogBtcDetail.newInstance(it) }
        }
        dialog?.show(supportFragmentManager)
    }

    private fun showDialogOther() {

        val dialog = DialogOther()
        dialog.show(supportFragmentManager, "")
        dialog.setOnClick {
            when (it) {
                TopicEnum.fibonacci -> router.toFibonacci()
                TopicEnum.filter_array -> router.toFibonacci()
                TopicEnum.prime_number -> router.toPrimeNumber()
                TopicEnum.validate -> router.toValidatePinCode()
            }
            dialog.dismiss()
        }
    }
}