package com.ktxdevelopment.biometrics.domain.usecase

data class NoteUsecases(
    val getNotes: GetNotesUsecase,
    val deleteNote: DeleteNoteUsecase,
    val addNote: AddNoteUsecase,
    val getNote: GetNoteByIdUsecase,
    val deleteAllNotes: DeleteAllNotesUsecase
)