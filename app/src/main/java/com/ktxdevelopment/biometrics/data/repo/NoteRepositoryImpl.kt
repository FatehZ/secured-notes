package com.ktxdevelopment.biometrics.data.repo

import com.ktxdevelopment.biometrics.data.data_source.NoteDao
import com.ktxdevelopment.biometrics.domain.model.note.Note
import com.ktxdevelopment.biometrics.domain.repo.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)


    override suspend fun deleteAllNotes() = dao.deleteAllNotes()

    override suspend fun insertNote(note: Note) = dao.insertNote(note)
}