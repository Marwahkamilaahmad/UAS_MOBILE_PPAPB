package com.example.praktikumuts2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities = [Note::class],
        version = 1,
        exportSchema = false)
    abstract class NoteRoomDatabase : RoomDatabase(){
        abstract fun noteDao() : NoteDao?

        companion object {
            @Volatile
            private var INSTANCE: NoteRoomDatabase? = null
            fun getDatabase(context: Context): NoteRoomDatabase? {
                if (INSTANCE == null) {
                    synchronized(NoteRoomDatabase::class.java) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NoteRoomDatabase::class.java, "data_menu"
                        ).build()
                    }
                }
                return INSTANCE
            }

        }


    }
