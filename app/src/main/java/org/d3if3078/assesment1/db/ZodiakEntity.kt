package org.d3if3078.assesment1.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zodiakk")
data class ZodiakEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var judulZodiak: String,
)
