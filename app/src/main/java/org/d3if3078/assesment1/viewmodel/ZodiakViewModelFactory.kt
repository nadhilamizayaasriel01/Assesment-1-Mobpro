package org.d3if3078.assesment1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3078.assesment1.db.ZodiakDao

class ZodiakViewModelFactory (
    private val db: ZodiakDao
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ZodiakViewModel::class.java)){
            return ZodiakViewModel(db) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}

