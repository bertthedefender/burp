package com.oldspeccy.composetest.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataItem::class], exportSchema = false, version = 2)
abstract class DemoDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: DemoDatabase? = null
        fun getInstance(
            context: Context
        ): DemoDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, DemoDatabase::class.java, "demo_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    abstract fun dataItemDao(): DataItemDao
}