package com.nut.cdev.bitcoinapplication.data.model

import android.os.Parcel
import android.os.Parcelable
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
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(TimeModel::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(BpiGroupModel::class.java.classLoader)
    ) {
    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(time, flags)
        parcel.writeString(disclaimer)
        parcel.writeString(chartName)
        parcel.writeParcelable(bpi, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BtcModel> {
        override fun createFromParcel(parcel: Parcel): BtcModel {
            return BtcModel(parcel)
        }

        override fun newArray(size: Int): Array<BtcModel?> {
            return arrayOfNulls(size)
        }
    }
}
