package com.example.atun.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(AtunRojo::class),version = 1)
abstract class AtunRojoDatabase : RoomDatabase() {
    abstract fun atunRojoDao() : AtunRojoDao

    companion object{
        @Volatile
        private var INSTANCE: AtunRojoDatabase? = null

        fun getDatabase(context: Context): AtunRojoDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AtunRojoDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/atun_rojo.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}