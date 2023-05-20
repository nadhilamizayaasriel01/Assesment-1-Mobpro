package org.d3if3078.assesment1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZodiakDao {
    @Insert
    fun insert(zodiakk : ZodiakEntity)

    @Query("SELECT * FROM zodiakk ORDER BY id DESC LIMIT 1")
    fun getLastZodiak(): LiveData<ZodiakEntity>

    @Query("DELETE FROM zodiakk")
    fun clearData()
}