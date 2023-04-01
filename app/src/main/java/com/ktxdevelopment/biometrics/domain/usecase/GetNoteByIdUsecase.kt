package com.ktxdevelopment.biometrics.domain.usecase

import com.ktxdevelopment.biometrics.domain.model.note.Note
import com.ktxdevelopment.biometrics.domain.repo.NoteRepository

class GetNoteByIdUsecase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}