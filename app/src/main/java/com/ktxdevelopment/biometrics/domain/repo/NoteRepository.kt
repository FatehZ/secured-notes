package com.ktxdevelopment.biometrics.domain.repo

import com.ktxdevelopment.biometrics.domain.model.note.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes() : Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun deleteNote(note: Note)

    suspend fun deleteAllNotes()

    suspend fun insertNote(note: Note)

}