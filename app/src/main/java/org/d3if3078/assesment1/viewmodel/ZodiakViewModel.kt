package org.d3if3078.assesment1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.db.ZodiakDao
import org.d3if3078.assesment1.db.ZodiakEntity
import org.d3if3078.assesment1.model.HasilZodiak
import org.d3if3078.assesment1.model.findZodiak

class ZodiakViewModel (private val db: ZodiakDao): ViewModel() {
    private val hasilZodiak = MutableLiveData<HasilZodiak>()

    fun findZodiak(bintang: String) {
        val dataZodiak = ZodiakEntity(
            judulZodiak = bintang
        )
        hasilZodiak.value = dataZodiak.findZodiak()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataZodiak)
            }
        }
    }

    fun getHasilZodiak(): LiveData<HasilZodiak?> = hasilZodiak
}
