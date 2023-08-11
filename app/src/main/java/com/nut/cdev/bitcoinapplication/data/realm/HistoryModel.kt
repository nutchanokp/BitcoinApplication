package com.nut.cdev.bitcoinapplication.data.realm

import com.nut.cdev.bitcoinapplication.data.model.GraphHistory
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class HistoryModel : RealmObject {
    @PrimaryKey
    var id: String = ""

    var number: Long = 0
    var gender: String? = null
    var weight: Double? = null
    var height: Double? = null
    var age: Int? = null
    var exercise: String? = null
    var bmi: Double? = null
    var bmr: Double? = null
    var body_fat: Double? = null
    var ibw: Double? = null
    var rdee: Double? = null
    var bmiTxt: String? = null
    var bmrTxt: String? = null
    var body_fatTxt: String? = null
    var ibwTxt: String? = null
    var rdeeTxt: String? = null
    var is_success: Boolean? = false
    var dateTimestamp: String? = null

    var healthType: String? = null
    var mindType: String? = null
    var mindResult: Int? = null
    var mindResultTxt: String? = null

    constructor() {}

    constructor(
        id: String,
        number: Long,
        gender: String?,
        weight: Double?,
        height: Double?,
        age: Int?,
        exercise: String?,
        bmi: Double?,
        bmr: Double?,
        body_fat: Double?,
        ibw: Double?,
        rdee: Double?,
        bmiTxt: String?,
        bmrTxt: String?,
        body_fatTxt: String?,
        ibwTxt: String?,
        rdeeTxt: String?,
        is_success: Boolean?,
        dateTimestamp: String?,
        healthType: String?,
        mindType: String?,
        mindResult: Int?,
        mindResultTxt: String?
    ) : super() {
        this.id = id
        this.number = number
        this.gender = gender
        this.weight = weight
        this.height = height
        this.age = age
        this.exercise = exercise
        this.bmi = bmi
        this.bmr = bmr
        this.body_fat = body_fat
        this.ibw = ibw
        this.rdee = rdee
        this.bmiTxt = bmiTxt
        this.bmrTxt = bmrTxt
        this.body_fatTxt = body_fatTxt
        this.ibwTxt = ibwTxt
        this.rdeeTxt = rdeeTxt
        this.is_success = is_success
        this.dateTimestamp = dateTimestamp
        this.healthType = healthType
        this.mindType = mindType
        this.mindResult = mindResult
        this.mindResultTxt = mindResultTxt
    }

    fun toHistory(): GraphHistory {
        return GraphHistory(
            id = this.id,
            number = this.number,
            gender = this.gender,
            weight = this.weight,
            height = this.height,
            age = this.age,
            exercise = this.exercise,
            bmi = this.bmi,
            bmr = this.bmr,
            body_fat = this.body_fat,
            ibw = this.ibw,
            rdee = this.rdee,
            bmiTxt = this.bmiTxt,
            bmrTxt = this.bmrTxt,
            body_fatTxt = this.body_fatTxt,
            ibwTxt = this.ibwTxt,
            rdeeTxt = this.rdeeTxt,
            is_success = this.is_success,
            dateTimestamp = this.dateTimestamp,
            healthType = this.healthType,
            mindType = this.mindType,
            mindResult = this.mindResult,
            mindResultTxt = this.mindResultTxt

        )

    }
}