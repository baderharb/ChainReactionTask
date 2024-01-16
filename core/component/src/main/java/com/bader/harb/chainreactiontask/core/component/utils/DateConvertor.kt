package com.bader.harb.chainreactiontask.core.component.utils

import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

object DateConvertor {

    fun getTimeAgo(timestamp: String): String {
        val timeInMillis = convertTimestampToMillis(timestamp)
        val currentTimeMillis = System.currentTimeMillis()
        return DateUtils.getRelativeTimeSpanString(
            timeInMillis,
            currentTimeMillis,
            DateUtils.MINUTE_IN_MILLIS
        ).toString()
    }

    private fun convertTimestampToMillis(timestamp: String): Long {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return try {
            val date = dateFormat.parse(timestamp)
            date.time
        } catch (e: ParseException) {
            e.printStackTrace()
            0
        }
    }
}