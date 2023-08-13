package com.nut.cdev.bitcoinapplication.views.main

import android.os.CountDownTimer
import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import com.nut.cdev.bitcoinapplication.data.repository.MainRepository
import com.nut.cdev.bitcoinapplication.utils.lifecycle.MutableLiveEvent
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    companion object {
        const val DELAY: Long = 60000
    }

    val btc = MutableLiveEvent<Response<BtcModel>>()
    val btcHistory = MutableLiveEvent<List<BtcHistoryModel>>()
    val countDownTimer = MutableLiveEvent<String>()

    fun getCurrentBtc() = btc.value?.body()

    fun getBtc() {
        viewModelScope.launch {
            btc.emit(repository.getBtc())
        }
        val handler = Handler()
        val refresh: Runnable = object : Runnable {
            override fun run() {
                viewModelScope.launch {
                    try {
                        val btac = repository.getBtc()
                        btc.emit(btac)

                    } catch (e: Exception) {
//                        Log.e(TAG, e.localizedMessage)
                    } finally {
                        repository.getBtcHistoryList().value?.let {
                            val first = it.first()
                            btcHistory.emit(it.filterNot { it.updated == first.updated })

                        }
                    }
                }
                countDown()
                handler.postDelayed(this, DELAY)
            }
        }
        handler.postDelayed(refresh, DELAY)
        countDown()
    }

    fun countDown() {
        object : CountDownTimer(DELAY, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                countDownTimer.emit("Refresh In : " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                countDownTimer.emit("done")
            }
        }.start()
    }

    fun deleteHistory(updatedISO: String) {
        repository.deleteHistory(updatedISO).value?.let {
            val first = it.first()
            btcHistory.emit(it.filterNot { it.updated == first.updated })

        }
    }

    init {
        getBtc()

        repository.getBtcHistoryList().value?.let {
            val first = it.first()
            btcHistory.emit(it.filterNot { it.updated == first.updated })

        }
    }

}

