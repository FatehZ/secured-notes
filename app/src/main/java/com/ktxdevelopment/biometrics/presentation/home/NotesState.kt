package com.ktxdevelopment.biometrics.presentation.home

import com.ktxdevelopment.biometrics.domain.model.note.Note
import com.ktxdevelopment.biometrics.domain.util.NoteOrder
import com.ktxdevelopment.biometrics.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)