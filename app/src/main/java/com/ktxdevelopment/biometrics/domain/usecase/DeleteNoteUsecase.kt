package com.ktxdevelopment.biometrics.domain.usecase

import com.ktxdevelopment.biometrics.domain.model.note.Note
import com.ktxdevelopment.biometrics.domain.repo.NoteRepository

class DeleteNoteUsecase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}