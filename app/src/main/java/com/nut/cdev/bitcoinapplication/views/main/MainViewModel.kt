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
        const val DELAY: Long = 6000
    }

    val btc = MutableLiveEvent<Response<BtcModel>>()
    val btcHistory = MutableLiveEvent<List<BtcHistoryModel>>()
    val countDownTimer = MutableLiveEvent<String>()

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

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                countDownTimer.emit("seconds remaining: " + millisUntilFinished / 1000)
            }

            // Callback function, fired
            // when the time is up
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

//    private var realm: Realm = Realm.getDefaultInstance()
//
//    val userName = MutableLiveEvent<String>()
//
//    init {
//        getName()
//    }
//
//    fun getName() {
//        val name = realm.where(NameModel::class.java).findAll().lastOrNull()?.name
//        name?.let { userName.emit(it) }
//    }
//
//    fun updateName(name: String) {
//        val target = realm.where(NameModel::class.java).findAll().lastOrNull()
//        realm.executeTransaction {
//            target?.name = name
//            realm.insertOrUpdate(target)
//        }
//        getName()
//    }
//
//    val history: LiveData<List<HistoryModel>>
//        get() = getHistory()
//
//    val getHealth: LiveData<HistoryModel>?
//        get() = getLastHealthHistory()
//
//    private fun getHistory(): MutableLiveData<List<HistoryModel>> {
//        val list = MutableLiveData<List<HistoryModel>>()
//        val notes = realm.where(HistoryModel::class.java).findAll()
//        list.value = notes?.subList(0, notes.size)
//        return list
//    }
//
//    private fun getLastHealthHistory(): MutableLiveData<HistoryModel>? {
//        val list = MutableLiveData<HistoryModel>()
//        val notes =
//            realm.where(HistoryModel::class.java).equalTo("healthType", HealthTypeEnum.HEALTH.name)
//                .findAll().lastOrNull()
//        list.value = notes ?: null
//        return list
//    }
//
//    fun getHistoryPHQ9(): HistoryModel? {
//        val result = realm.where(HistoryModel::class.java)
//            .equalTo("healthType", HealthTypeEnum.MIND.name)
//            .equalTo("mindType", CalculatePsychologyType.PHQ9.name)
//            .findAll().lastOrNull()
//        return result
//    }
//
//    fun getHistoryTMSE(): HistoryModel? {
//        val result = realm.where(HistoryModel::class.java)
//            .equalTo("healthType", HealthTypeEnum.MIND.name)
//            .equalTo("mindType", CalculatePsychologyType.TMSE.name)
//            .findAll().lastOrNull()
//        return result
//    }
//
//    fun getHistoryDASS21(): HistoryModel? {
//        val result = realm.where(HistoryModel::class.java)
//            .equalTo("healthType", HealthTypeEnum.MIND.name)
//            .equalTo("mindType", CalculatePsychologyType.DASS21.name)
//            .findAll().lastOrNull()
//        return result
//    }
//
//    private var count = 0
//
//    fun getCurrentCount(): Int {
//        return count
//    }
//
//    fun getUpdatedCount(): Int {
//        return ++count
//    }
}

