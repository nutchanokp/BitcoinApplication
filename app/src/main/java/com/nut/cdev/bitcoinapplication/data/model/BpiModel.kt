package com.nut.cdev.bitcoinapplication.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BpiGroupModel(

    @SerializedName("disclaimer")
    var disclaimer: String? = null,
    @SerializedName("USD")
    var USD: BpiModel? = null,
    @SerializedName("GBP")
    var GBP: BpiModel? = null,
    @SerializedName("EUR")
    var EUR: BpiModel? = null,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(BpiModel::class.java.classLoader),
        parcel.readParcelable(BpiModel::class.java.classLoader),
        parcel.readParcelable(BpiModel::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(disclaimer)
        parcel.writeParcelable(USD, flags)
        parcel.writeParcelable(GBP, flags)
        parcel.writeParcelable(EUR, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BpiGroupModel> {
        override fun createFromParcel(parcel: Parcel): BpiGroupModel {
            return BpiGroupModel(parcel)
        }

        override fun newArray(size: Int): Array<BpiGroupModel?> {
            return arrayOfNulls(size)
        }
    }

}


data class BpiModel(
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("rate")
    var rate: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("rate_float")
    var rate_float: Float? = null,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(symbol)
        parcel.writeString(rate)
        parcel.writeString(description)
        parcel.writeValue(rate_float)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BpiModel> {
        override fun createFromParcel(parcel: Parcel): BpiModel {
            return BpiModel(parcel)
        }

        override fun newArray(size: Int): Array<BpiModel?> {
            return arrayOfNulls(size)
        }
    }

}
