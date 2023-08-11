package com.nut.cdev.bitcoinapplication.views.main

import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseActivity
import com.nut.cdev.bitcoinapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    private val viewModel: MainViewModel by viewModel()

    private val adapter = HistoryAdapter()
    override fun initView() {
        binding.rvHistory.adapter = adapter
    }

    override fun initInstances() {
        binding.btnFibonacci.setOnClickListener {
            router.toFibonacci()
        }
    }

    override fun setupObserve() {

        viewModel.btc.observe(this) {
            binding.tvUpdated.text = it.body()?.time?.updated.toString()
            binding.tvUpdatedISO.text = it.body()?.time?.updatedISO.toString()
            binding.tvUpdateduk.text = it.body()?.time?.updateduk.toString()

        }
        viewModel.btcHistory.observe(this) {
            it.let { it1 -> adapter.setItems(it1.toMutableList()) }

        }
        viewModel.countDownTimer.observe(this) {
            binding.tvCountdown.text = it
        }
    }
}