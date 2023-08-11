package com.nut.cdev.bitcoinapplication.data.model

import com.google.gson.annotations.SerializedName
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import java.util.UUID

data class BtcModel(
    @SerializedName("time")
    var time: TimeModel? = null,
    @SerializedName("disclaimer")
    var disclaimer: String? = null,
    @SerializedName("chartName")
    var chartName: String? = null,
    @SerializedName("bpi")
    var bpi: BpiGroupModel? = null
) {
    fun toBtcHistoryModel(): BtcHistoryModel {
        return BtcHistoryModel().apply {
            id = UUID.randomUUID().toString()
            updated = this@BtcModel.time?.updated
            updatedISO = this@BtcModel.time?.updatedISO
            updateduk = this@BtcModel.time?.updateduk

            disclaimer = this@BtcModel.disclaimer
            chartName = this@BtcModel.chartName

            bpi_disclaimer = this@BtcModel.bpi?.disclaimer

            USD_code = this@BtcModel.bpi?.USD?.code
            USD_symbol = this@BtcModel.bpi?.USD?.symbol
            USD_rate = this@BtcModel.bpi?.USD?.rate
            USD_description = this@BtcModel.bpi?.USD?.description
            USD_rate_float = this@BtcModel.bpi?.USD?.rate_float

            GBP_code = this@BtcModel.bpi?.USD?.code
            GBP_symbol = this@BtcModel.bpi?.USD?.symbol
            GBP_rate = this@BtcModel.bpi?.USD?.rate
            GBP_description = this@BtcModel.bpi?.USD?.description
            GBP_rate_float = this@BtcModel.bpi?.USD?.rate_float

            EUR_code = this@BtcModel.bpi?.USD?.code
            EUR_symbol = this@BtcModel.bpi?.USD?.symbol
            EUR_rate = this@BtcModel.bpi?.USD?.rate
            EUR_description = this@BtcModel.bpi?.USD?.description
            EUR_rate_float = this@BtcModel.bpi?.USD?.rate_float

        }
    }
}
