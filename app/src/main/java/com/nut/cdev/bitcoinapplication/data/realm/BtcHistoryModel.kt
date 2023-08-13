package com.nut.cdev.bitcoinapplication.data.realm

import com.google.gson.annotations.SerializedName
import com.nut.cdev.bitcoinapplication.data.model.BpiGroupModel
import com.nut.cdev.bitcoinapplication.data.model.BpiModel
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.model.TimeModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.UUID

@RealmClass
open class BtcHistoryModel : RealmObject {

    @PrimaryKey
    var id: String = ""

    @SerializedName("updated")
    var updated: String? = null

    @SerializedName("updatedISO")
    var updatedISO: String? = null

    @SerializedName("updateduk")
    var updateduk: String? = null

    @SerializedName("disclaimer")
    var disclaimer: String? = null

    @SerializedName("chartName")
    var chartName: String? = null

    @SerializedName("bpi_disclaimer")
    var bpi_disclaimer: String? = null

    @SerializedName("USD_code")
    var USD_code: String? = null

    @SerializedName("USD_symbol")
    var USD_symbol: String? = null

    @SerializedName("USD_rate")
    var USD_rate: String? = null

    @SerializedName("USD_description")
    var USD_description: String? = null

    @SerializedName("USD_rate_float")
    var USD_rate_float: Float? = null

    @SerializedName("EUR_code")
    var EUR_code: String? = null

    @SerializedName("EUR_symbol")
    var EUR_symbol: String? = null

    @SerializedName("EUR_rate")
    var EUR_rate: String? = null

    @SerializedName("EUR_description")
    var EUR_description: String? = null

    @SerializedName("EUR_rate_float")
    var EUR_rate_float: Float? = null

    @SerializedName("GBP_code")
    var GBP_code: String? = null

    @SerializedName("GBP_symbol")
    var GBP_symbol: String? = null

    @SerializedName("GBP_rate")
    var GBP_rate: String? = null

    @SerializedName("GBP_description")
    var GBP_description: String? = null

    @SerializedName("GBP_rate_float")
    var GBP_rate_float: Float? = null
    constructor()
    constructor(
        id: String,
        updated: String?,
        updatedISO: String?,
        updateduk: String?,
        disclaimer: String?,
        chartName: String?,
        bpi_disclaimer: String?,
        USD_code: String?,
        USD_symbol: String?,
        USD_rate: String?,
        USD_description: String?,
        USD_rate_float: Float?,
        EUR_code: String?,
        EUR_symbol: String?,
        EUR_rate: String?,
        EUR_description: String?,
        EUR_rate_float: Float?,
        GBP_code: String?,
        GBP_symbol: String?,
        GBP_rate: String?,
        GBP_description: String?,
        GBP_rate_float: Float?
    ) : super() {
        this.id = id
        this.updated = updated
        this.updatedISO = updatedISO
        this.updateduk = updateduk
        this.disclaimer = disclaimer
        this.chartName = chartName
        this.bpi_disclaimer = bpi_disclaimer
        this.USD_code = USD_code
        this.USD_symbol = USD_symbol
        this.USD_rate = USD_rate
        this.USD_description = USD_description
        this.USD_rate_float = USD_rate_float
        this.EUR_code = EUR_code
        this.EUR_symbol = EUR_symbol
        this.EUR_rate = EUR_rate
        this.EUR_description = EUR_description
        this.EUR_rate_float = EUR_rate_float
        this.GBP_code = GBP_code
        this.GBP_symbol = GBP_symbol
        this.GBP_rate = GBP_rate
        this.GBP_description = GBP_description
        this.GBP_rate_float = GBP_rate_float
    }

    fun toBtcModel(): BtcModel {
        return BtcModel().apply {
            time = TimeModel().apply {
                updated = this@BtcHistoryModel.updated
                updatedISO = this@BtcHistoryModel.updatedISO
                updateduk = this@BtcHistoryModel.updateduk

            }
            disclaimer = this@BtcHistoryModel.disclaimer
            chartName = this@BtcHistoryModel.chartName

            bpi = BpiGroupModel().apply {
                disclaimer = this@BtcHistoryModel.bpi_disclaimer
                USD = BpiModel().apply {
                    code= this@BtcHistoryModel.USD_code
                    symbol= this@BtcHistoryModel.USD_symbol
                    rate= this@BtcHistoryModel.USD_rate
                    description= this@BtcHistoryModel.USD_description
                    rate_float= this@BtcHistoryModel.USD_rate_float

                }
                GBP = BpiModel().apply {
                    code= this@BtcHistoryModel.GBP_code
                    symbol= this@BtcHistoryModel.GBP_symbol
                    rate= this@BtcHistoryModel.GBP_rate
                    description= this@BtcHistoryModel.GBP_description
                    rate_float= this@BtcHistoryModel.GBP_rate_float

                }
                EUR = BpiModel().apply {
                    code= this@BtcHistoryModel.EUR_code
                    symbol= this@BtcHistoryModel.EUR_symbol
                    rate= this@BtcHistoryModel.EUR_rate
                    description= this@BtcHistoryModel.EUR_description
                    rate_float= this@BtcHistoryModel.EUR_rate_float

                }
            }
        }
    }
}