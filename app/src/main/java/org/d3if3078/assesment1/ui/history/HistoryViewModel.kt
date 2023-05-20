package org.d3if3078.assesment1.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3078.assesment1.db.ZodiakDao

class HistoryViewModel(private val db: ZodiakDao) : ViewModel() {
    val data = db.getLastZodiak()
    fun hapusData() = viewModelScope.launch{
        withContext(Dispatchers.IO){
            db.clearData()
        }
    }

}