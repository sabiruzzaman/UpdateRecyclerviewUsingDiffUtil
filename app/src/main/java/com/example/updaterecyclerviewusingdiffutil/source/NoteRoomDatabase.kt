package com.example.updaterecyclerviewusingdiffutil.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */

@Database(
    entities = [Note::class],
    version = 1, exportSchema = false
)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null
        operator fun invoke(context: Context): NoteRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteRoomDatabase::class.java,
                    "note_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}