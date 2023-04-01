package com.ktxdevelopment.biometrics.data.data_source

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ktxdevelopment.biometrics.presentation.util.InverseList


class TimestampConverter {

    @TypeConverter
    fun fromTimestamp(time: InverseList<*>): String { return Gson().toJson(time) }

    @TypeConverter fun toTimestamp(str: String): InverseList<*>? { return Gson().fromJson(str, InverseList::class.java) }

}