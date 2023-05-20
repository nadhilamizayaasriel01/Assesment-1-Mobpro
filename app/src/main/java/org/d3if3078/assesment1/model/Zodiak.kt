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
                R.drawable.aquarius
        }else if (zodiaknya.equals("Scorpio", ignoreCase = true)){
                R.drawable.scorpio
        }else if(zodiaknya.equals("Capricorn", ignoreCase = true)){
                R.drawable.capricorn
        }else if(zodiaknya.equals("Aries", ignoreCase = true)){
                R.drawable.aries
        }else if(zodiaknya.equals("Taurus", ignoreCase = true)){
                R.drawable.taurus
        }else if (zodiaknya.equals("Gemini", ignoreCase = true)){
                R.drawable.gemini
        }else if(zodiaknya.equals("Virgo", ignoreCase = true)){
                R.drawable.virgo
        }else if (zodiaknya.equals("Sagitarius", ignoreCase = true)){
                R.drawable.sagitarius
        }else if (zodiaknya.equals("Cancer", ignoreCase = true)){
                R.drawable.cancer
        }else if (zodiaknya.equals("Libra", ignoreCase = true)){
                R.drawable.libra
        }else if(zodiaknya.equals("Pisces", ignoreCase = true)){
                R.drawable.pisces
        }else if(zodiaknya.equals("Leo", ignoreCase = true)){
                R.drawable.leo
        }else {
                R.drawable.ghost
        }
        return HasilZodiak(judulZodiak, gambar, deskripsinya)
}


