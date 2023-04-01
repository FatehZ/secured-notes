package com.ktxdevelopment.biometrics.di

import android.app.Application
import androidx.room.Room
import com.ktxdevelopment.biometrics.data.data_source.NoteDatabase
import com.ktxdevelopment.biometrics.data.repo.NoteRepositoryImpl
import com.ktxdevelopment.biometrics.domain.repo.NoteRepository
import com.ktxdevelopment.biometrics.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: NoteRepository): NoteUsecases {
        return NoteUsecases(
            getNotes = GetNotesUsecase(repository),
            deleteNote = DeleteNoteUsecase(repository),
            addNote = AddNoteUsecase(repository),
            getNote = GetNoteByIdUsecase(repository),
            deleteAllNotes = DeleteAllNotesUsecase(repository)
        )
    }
}