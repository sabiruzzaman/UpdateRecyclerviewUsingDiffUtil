package com.example.updaterecyclerviewusingdiffutil.di

import android.content.Context
import com.example.updaterecyclerviewusingdiffutil.source.NoteDao
import com.example.updaterecyclerviewusingdiffutil.source.NoteRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDao(
        noteRoomDatabase: NoteRoomDatabase
    ): NoteDao = noteRoomDatabase.getNoteDao()

    @Provides
    @Singleton
    fun provideNoteRoomDatabase(
        @ApplicationContext appContext: Context
    ): NoteRoomDatabase =
        NoteRoomDatabase.invoke(appContext)

}