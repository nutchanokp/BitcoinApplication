package com.nut.cdev.bitcoinapplication.views.main

import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.base.BaseActivity
import com.nut.cdev.bitcoinapplication.databinding.ActivityMainBinding
import com.nut.cdev.bitcoinapplication.enums.TopicEnum
import com.nut.cdev.bitcoinapplication.ext.enableSwipeRecyclerView
import com.nut.cdev.bitcoinapplication.views.dialog.DialogOther
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    private val viewModel: MainViewModel by viewModel()

    private val adapter = HistoryAdapter()
    override fun initView() {
        binding.rvHistory.adapter = adapter

        binding.rvHistory.enableSwipeRecyclerView(
            this,
            adapter
        ) {
            runBlocking {
//                adapter.deleteItem(it)
                it.updatedISO?.let { it1 -> viewModel.deleteHistory(it1) }
            }
        }
    }

    override fun initInstances() {
        binding.apply {

            btnMenu.setOnClickListener {

                val dialog = DialogOther()
                dialog.show(supportFragmentManager, "")
                dialog.setOnClick {
                    when (it) {
                        TopicEnum.fibonacci -> router.toFibonacci()
                        TopicEnum.filter_array -> router.toFibonacci()
                        TopicEnum.prime_number -> router.toFibonacci()
                        TopicEnum.validate -> router.toFibonacci()
                    }
                }
            }
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