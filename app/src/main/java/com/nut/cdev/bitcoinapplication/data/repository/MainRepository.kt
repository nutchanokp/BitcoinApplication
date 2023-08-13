package com.nut.cdev.bitcoinapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.nut.cdev.bitcoinapplication.data.ApiService
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import io.realm.Realm
import io.realm.Sort
import retrofit2.Response

class MainRepository(private val apiHelper: ApiService) {

    private val realm: Realm = Realm.getDefaultInstance()
    suspend fun getBtc(): Response<BtcModel> {
        val btcResponse = apiHelper.getBtc()
        btcResponse.body()?.let { addBtcHistory(it) }
        return btcResponse
    }

    fun getBtcHistoryList(): MutableLiveData<List<BtcHistoryModel>> {
        val list = MutableLiveData<List<BtcHistoryModel>>()
        val notes =
            realm.where(BtcHistoryModel::class.java).findAll().sort("updatedISO", Sort.DESCENDING)
        list.value = notes?.subList(0, notes.size)
        return list
    }

    fun deleteHistory(updatedISO: String): MutableLiveData<List<BtcHistoryModel>> {
        val list = MutableLiveData<List<BtcHistoryModel>>()
        realm.executeTransaction {
            val notes = realm.where(BtcHistoryModel::class.java)
                .equalTo("updatedISO", updatedISO)
                .findFirst()

            notes?.deleteFromRealm()
        }
        val notes =
            realm.where(BtcHistoryModel::class.java).findAll().sort("updatedISO", Sort.DESCENDING)
        list.value = notes?.subList(0, notes.size)
        return list
    }


    private fun addBtcHistory(btcModel: BtcModel) {
        var target = realm.where(BtcHistoryModel::class.java).findAll()
            .lastOrNull()?.updated == btcModel.time?.updated

        if (!target) {
            realm.executeTransaction { r: Realm ->
                val newModel = btcModel.toBtcHistoryModel()
                realm.insertOrUpdate(newModel)
            }
        }
    }
}