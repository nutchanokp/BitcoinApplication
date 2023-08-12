package com.nut.cdev.number_picker

import android.os.Parcel
import android.os.Parcelable

data class NumberPickerModel(

    val title: String? = null,
    val default: Int? = 1,
    val tUnit: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeValue(default)
        parcel.writeString(tUnit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NumberPickerModel> {
        override fun createFromParcel(parcel: Parcel): NumberPickerModel {
            return NumberPickerModel(parcel)
        }

        override fun newArray(size: Int): Array<NumberPickerModel?> {
            return arrayOfNulls(size)
        }
    }

}
