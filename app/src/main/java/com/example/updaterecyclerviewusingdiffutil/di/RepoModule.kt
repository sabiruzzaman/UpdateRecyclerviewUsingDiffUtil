package com.example.updaterecyclerviewusingdiffutil.di

import com.example.updaterecyclerviewusingdiffutil.repository.NoteRepository
import com.example.updaterecyclerviewusingdiffutil.source.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideUserRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }
}