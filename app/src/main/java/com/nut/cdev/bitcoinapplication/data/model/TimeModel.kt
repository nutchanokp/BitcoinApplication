package com.nut.cdev.bitcoinapplication.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TimeModel(
    @SerializedName("updated")
    var updated: String? = null,
    @SerializedName("updatedISO")
    var updatedISO: String? = null,
    @SerializedName("updateduk")
    var updateduk: String? = null
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(updated)
        parcel.writeString(updatedISO)
        parcel.writeString(updateduk)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeModel> {
        override fun createFromParcel(parcel: Parcel): TimeModel {
            return TimeModel(parcel)
        }

        override fun newArray(size: Int): Array<TimeModel?> {
            return arrayOfNulls(size)
        }
    }

}
