package com.nut.cdev.bitcoinapplication.ext

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


enum class DateFormat(val format: String) {
    FULL_NAME_MONTH("MMMM"),
    FULL_NAME_DAY("EEEE"),
    NAME_DAY("EE"),
    NAME_MONTH("MMM"),
    DAY("dd"),
    MONTH("MMM"),
    YEAR("YYYY"),
    TIME("HH:mm"),
    TIME_AM_PM("hh:mm aa"),
    TIME_HOUR_MINUTE("HH:mm:ss"),
    TIME_12("H:m"),
    TIME_MINUTE("mm:ss"),
    DATE_TIME_NO_SEC("yyyy-MM-dd HH:mm"),
    DATE_TIME_HOUR("dd/MM/yyyy HH:mm"),
    SHOW("dd/MM/yyyy"),
    SHOW_REPORT("dd.MM.yyyy"),
    FROM_SERVICE("yyyy-MM-dd"),
    FROM_SERVICE_TIME("yyyy-MM-dd HH:mm:ss"),
    DAY_MONTH_NOT_HYPHEN("dd MMM"),
    DAY_MONTH_YEAR_NOT_HYPHEN("dd MMM yyyy"),
    DAY_FULL_MONTH_YEAR_NOT_HYPHEN("dd MMMM yyyy"),
    FULL_DATE("EEEE dd MMMM yyyy "),
    DASH("yyyy-MM-dd-HH-MM-ss"),
    UNDERSCORE("yyyy_MM_dd_HH_mm_ss")
}

fun String.toShowDate(): String {
    return convertDate(this, DateFormat.FROM_SERVICE_TIME, DateFormat.SHOW)
}

fun String.toShowTime(): String {
    return convertDate(this, DateFormat.FROM_SERVICE_TIME, DateFormat.TIME_HOUR_MINUTE)
}

private fun convertDate(input: String, currentFormat: DateFormat, toFormat: DateFormat): String {
    return convertDate(input, currentFormat, toFormat, null)
}

private fun convertDate(
    input: String,
    currentFormat: DateFormat,
    toFormat: DateFormat,
    timeZone: TimeZone?
): String {
    val locale = getAppCurrentLocale()
    val inFormat = SimpleDateFormat(currentFormat.format)
    inFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = inFormat.parse(input)
    val outFormat = SimpleDateFormat(toFormat.format, locale)
    return outFormat.format(date)
}
fun getAppCurrentLocale(): Locale {
    val locale =  Locale("th", "TH")
    return locale
}