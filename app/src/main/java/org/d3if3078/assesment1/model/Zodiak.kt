package org.d3if3078.assesment1.model

import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.db.ZodiakEntity

fun ZodiakEntity.findZodiak(): HasilZodiak {
        val zodiaknya = judulZodiak
        val deskripsinya = if (zodiaknya.equals("Aquarius", ignoreCase = true)){
                R.string.desc_aquarius
        }else if (zodiaknya.equals("Scorpio", ignoreCase = true)){
                R.string.desc_scorpio
        }else if(zodiaknya.equals("Capricorn", ignoreCase = true)){
                R.string.desc_capricorn
        }else if(zodiaknya.equals("Aries", ignoreCase = true)){
                R.string.desc_aries
        }else if(zodiaknya.equals("Taurus", ignoreCase = true)){
                R.string.desc_taurus
        }else if (zodiaknya.equals("Gemini", ignoreCase = true)){
                R.string.desc_gemini
        }else if(zodiaknya.equals("Virgo", ignoreCase = true)){
                R.string.desc_virgo
        }else if (zodiaknya.equals("Sagitarius", ignoreCase = true)){
                R.string.desc_sagitarius
        }else if (zodiaknya.equals("Cancer", ignoreCase = true)){
                R.string.desc_cancer
        }else if (zodiaknya.equals("Libra", ignoreCase = true)){
                R.string.desc_libra
        }else if(zodiaknya.equals("Pisces", ignoreCase = true)){
                R.string.desc_pisces
        }else if(zodiaknya.equals("Leo", ignoreCase = true)){
                R.string.desc_leo
        }else {
                R.string.tidak_ada_des
        }
        val gambar = if(zodiaknya.equals("Aquarius", ignoreCase = true)){
                "aquarius"
        }else if (zodiaknya.equals("Scorpio", ignoreCase = true)){
                "scorpio"
        }else if(zodiaknya.equals("Capricorn", ignoreCase = true)){
                "capricorn"
        }else if(zodiaknya.equals("Aries", ignoreCase = true)){
                "aries"
        }else if(zodiaknya.equals("Taurus", ignoreCase = true)){
                "taurus"
        }else if (zodiaknya.equals("Gemini", ignoreCase = true)){
                "gemini"
        }else if(zodiaknya.equals("Virgo", ignoreCase = true)){
                "virgo"
        }else if (zodiaknya.equals("Sagitarius", ignoreCase = true)){
                "sagitarius"
        }else if (zodiaknya.equals("Cancer", ignoreCase = true)){
                "cancer"
        }else if (zodiaknya.equals("Libra", ignoreCase = true)){
                "libra"
        }else if(zodiaknya.equals("Pisces", ignoreCase = true)){
                "pisces"
        }else if(zodiaknya.equals("Leo", ignoreCase = true)){
                "leo"
        }else {
                "ghost"
        }
        return HasilZodiak(judulZodiak, gambar,  deskripsinya = String())
}


