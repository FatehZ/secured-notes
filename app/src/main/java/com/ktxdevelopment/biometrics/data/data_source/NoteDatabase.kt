package com.ktxdevelopment.biometrics.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ktxdevelopment.biometrics.domain.model.note.Note

@TypeConverters(value = [TimestampConverter::class])
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract val dao: NoteDao

    companion object {
        const val DB_NAME = "notedb"
    }

}