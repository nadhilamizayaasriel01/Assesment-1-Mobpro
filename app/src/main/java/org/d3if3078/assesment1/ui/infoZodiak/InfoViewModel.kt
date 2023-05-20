package org.d3if3078.assesment1.ui.infoZodiak

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.model.InfoZodiak

class InfoViewModel: ViewModel(){

    private val data = MutableLiveData<List<InfoZodiak>>()

    init {
        data.value = initData()
    }
    private fun initData(): List<InfoZodiak>{
        return listOf(
            InfoZodiak("Aries", "21 Maret - 19 April", R.drawable.aries),
            InfoZodiak("Taurus", "20 April - 20 Mei", R.drawable.taurus),
            InfoZodiak("Gemini", "21 Mei - 20 Juni", R.drawable.gemini),
            InfoZodiak("Cancer", "21 Juni - 22 Juli", R.drawable.cancer),
            InfoZodiak("Leo", "23 Juli - 22 Agustus", R.drawable.leo),
            InfoZodiak("Virgo", "23 Agustus - 22 September", R.drawable.virgo),
            InfoZodiak("Libra", "23 September - 22 Oktober", R.drawable.libra),
            InfoZodiak("Scorpio", "23 Oktober - 21 November", R.drawable.scorpio),
            InfoZodiak("Sagitarius", "22 November - 21 Desember", R.drawable.sagitarius),
            InfoZodiak("Capricorn", "22 Desember - 19 Januari", R.drawable.capricorn),
            InfoZodiak("Aquarius", "20 Januari - 18 Februari", R.drawable.aquarius),
            InfoZodiak("Pisces", "19 Februari - 20 Maret", R.drawable.pisces),
        )
    }
    fun getData(): LiveData<List<InfoZodiak>> = data
    }