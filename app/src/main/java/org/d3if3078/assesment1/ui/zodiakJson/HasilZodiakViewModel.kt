package org.d3if3078.assesment1.ui.zodiakJson

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3078.assesment1.model.HasilZodiak
import org.d3if3078.assesment1.network.HasilZodiakApi

class HasilZodiakViewModel : ViewModel() {

    private val data = MutableLiveData<List<HasilZodiak>>()
    private val status = MutableLiveData<HasilZodiakApi.ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch  (Dispatchers.IO){
            status.postValue(HasilZodiakApi.ApiStatus.LOADING)
        try {
            data.postValue(HasilZodiakApi.service.getHasilZodiak())
            status.postValue(HasilZodiakApi.ApiStatus.SUCCESS)
        }catch (e : Exception){
            Log.d("HasilZodiakViewModel", "Failure: ${e.message}")
            status.postValue(HasilZodiakApi.ApiStatus.FAILED)
        }
        }
    }

    fun getData() : LiveData<List<HasilZodiak>> = data

    fun getStatus() : LiveData<HasilZodiakApi.ApiStatus> = status
}