package org.d3if3078.assesment1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ZodiakEntity::class], version = 1, exportSchema = false)

abstract class ZodiakDb : RoomDatabase(){
    abstract val dao : ZodiakDao

    companion object{
        @Volatile
        private var INSTANCE: ZodiakDb? = null

        fun getInstance(context: Context): ZodiakDb{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ZodiakDb::class.java,
                        "bmi.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}