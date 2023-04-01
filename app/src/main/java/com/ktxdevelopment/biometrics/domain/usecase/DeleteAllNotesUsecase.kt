package com.ktxdevelopment.biometrics.domain.usecase

import com.ktxdevelopment.biometrics.domain.repo.NoteRepository

class DeleteAllNotesUsecase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke() {
        repository.deleteAllNotes()
    }
}