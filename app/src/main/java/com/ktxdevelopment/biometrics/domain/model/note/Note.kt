package com.ktxdevelopment.biometrics.domain.model.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ktxdevelopment.biometrics.presentation.util.InverseList


@Entity(tableName = "note")
data class Note(
    val title: String = "",
    val content: String = "",
    val timestamp: InverseList<Long>,
    @PrimaryKey val id: Int? = null
)