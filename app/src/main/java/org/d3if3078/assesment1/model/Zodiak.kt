package org.d3if3078.assesment1.model

import android.content.res.Resources
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.db.ZodiakEntity

fun ZodiakEntity.findZodiak(resources: Resources): HasilZodiak {
        val zodiaknya = judulZodiak
//        val deskripsinya = if (zodiaknya.equals("Aquarius", ignoreCase = true)){
//                R.string.desc_aquarius
//        }else if (zodiaknya.equals("Scorpio", ignoreCase = true)){
//                R.string.desc_scorpio
//        }else if(zodiaknya.equals("Capricorn", ignoreCase = true)){
//                R.string.desc_capricorn
//        }else if(zodiaknya.equals("Aries", ignoreCase = true)){
//                R.string.desc_aries
//        }else if(zodiaknya.equals("Taurus", ignoreCase = true)){
//                R.string.desc_taurus
//        }else if (zodiaknya.equals("Gemini", ignoreCase = true)){
//                R.string.desc_gemini
//        }else if(zodiaknya.equals("Virgo", ignoreCase = true)){
//                R.string.desc_virgo
//        }else if (zodiaknya.equals("Sagitarius", ignoreCase = true)){
//                R.string.desc_sagitarius
//        }else if (zodiaknya.equals("Cancer", ignoreCase = true)){
//                R.string.desc_cancer
//        }else if (zodiaknya.equals("Libra", ignoreCase = true)){
//                R.string.desc_libra
//        }else if(zodiaknya.equals("Pisces", ignoreCase = true)){
//                R.string.desc_pisces
//        }else if(zodiaknya.equals("Leo", ignoreCase = true)){
//                R.string.desc_leo
//        }else {
//                R.string.tidak_ada_des
//        }

        val deskripsiResourcesId = when {
                zodiaknya.equals("Aquarius", ignoreCase = true) -> R.string.desc_aquarius
                zodiaknya.equals("Scorpio", ignoreCase = true) -> R.string.desc_scorpio
                zodiaknya.equals("Capricorn", ignoreCase = true) -> R.string.desc_capricorn
                zodiaknya.equals("Aries", ignoreCase = true) -> R.string.desc_aries
                zodiaknya.equals("Taurus", ignoreCase = true) -> R.string.desc_taurus
                zodiaknya.equals("Gemini", ignoreCase = true) -> R.string.desc_gemini
                zodiaknya.equals("Virgo", ignoreCase = true) -> R.string.desc_virgo
                zodiaknya.equals("Sagitarius", ignoreCase = true) -> R.string.desc_sagitarius
                zodiaknya.equals("Cancer", ignoreCase = true) -> R.string.desc_cancer
                zodiaknya.equals("Libra", ignoreCase = true) -> R.string.desc_libra
                zodiaknya.equals("Pisces", ignoreCase = true) -> R.string.desc_pisces
                zodiaknya.equals("Leo", ignoreCase = true) -> R.string.desc_leo
                else -> R.string.tidak_ada_des
        }
        val deskripsi = resources.getString(deskripsiResourcesId)

//
        val gambar = when {
                zodiaknya.equals("Aquarius", ignoreCase = true) -> "aquarius"
                zodiaknya.equals("Scorpio", ignoreCase = true) -> "scorpio"
                zodiaknya.equals("Capricorn", ignoreCase = true) -> "capricorn"
                zodiaknya.equals("Aries", ignoreCase = true) -> "aries"
                zodiaknya.equals("Taurus", ignoreCase = true) -> "taurus"
                zodiaknya.equals("Gemini", ignoreCase = true) -> "gemini"
                zodiaknya.equals("Virgo", ignoreCase = true) -> "virgo"
                zodiaknya.equals("Sagitarius", ignoreCase = true) -> "sagitarius"
                zodiaknya.equals("Cancer", ignoreCase = true) -> "cancer"
                zodiaknya.equals("Libra", ignoreCase = true) -> "libra"
                zodiaknya.equals("Pisces", ignoreCase = true) -> "pisces"
                zodiaknya.equals("Leo", ignoreCase = true) -> "leo"
                else -> "ghost"
        }
        return HasilZodiak(judulZodiak, gambar,  deskripsi)
}




