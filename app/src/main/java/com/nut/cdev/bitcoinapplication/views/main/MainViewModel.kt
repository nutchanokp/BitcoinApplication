package com.nut.cdev.bitcoinapplication.views.main

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

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

