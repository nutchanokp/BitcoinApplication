package com.nut.cdev.bitcoinapplication.data.model

import android.os.Parcel
import android.os.Parcelable

data class GraphHistory(

    var id: String? = null,

    var number: Long = 0,
    var gender: String? = null,
    var weight: Double? = null,
    var height: Double? = null,
    var age: Int? = null,
    var exercise: String? = null,
    var bmi: Double? = null,
    var bmr: Double? = null,
    var body_fat: Double? = null,
    var ibw: Double? = null,
    var rdee: Double? = null,
    var bmiTxt: String? = null,
    var bmrTxt: String? = null,
    var body_fatTxt: String? = null,
    var ibwTxt: String? = null,
    var rdeeTxt: String? = null,
    var is_success: Boolean? = false,
    var dateTimestamp: String? = null,

    var healthType: String? = null,
    var mindType: String? = null,
    var mindResult: Int? = null,
    var mindResultTxt: String? = null,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeLong(number)
        parcel.writeString(gender)
        parcel.writeValue(weight)
        parcel.writeValue(height)
        parcel.writeValue(age)
        parcel.writeString(exercise)
        parcel.writeValue(bmi)
        parcel.writeValue(bmr)
        parcel.writeValue(body_fat)
        parcel.writeValue(ibw)
        parcel.writeValue(rdee)
        parcel.writeString(bmiTxt)
        parcel.writeString(bmrTxt)
        parcel.writeString(body_fatTxt)
        parcel.writeString(ibwTxt)
        parcel.writeString(rdeeTxt)
        parcel.writeValue(is_success)
        parcel.writeString(dateTimestamp)
        parcel.writeString(healthType)
        parcel.writeString(mindType)
        parcel.writeValue(mindResult)
        parcel.writeString(mindResultTxt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GraphHistory> {
        override fun createFromParcel(parcel: Parcel): GraphHistory {
            return GraphHistory(parcel)
        }

        override fun newArray(size: Int): Array<GraphHistory?> {
            return arrayOfNulls(size)
        }
    }

}