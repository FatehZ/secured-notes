package com.ktxdevelopment.biometrics.domain.usecase

import com.ktxdevelopment.biometrics.domain.model.note.InvalidNoteException
import com.ktxdevelopment.biometrics.domain.model.note.Note
import com.ktxdevelopment.biometrics.domain.repo.NoteRepository

class AddNoteUsecase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}