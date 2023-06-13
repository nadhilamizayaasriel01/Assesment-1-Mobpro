package org.d3if3078.assesment1.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.d3if3078.assesment1.model.HasilZodiak
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
            "nadhilamizayaasriel01/Assesment-1-Mobpro/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface HasilZodiakApiService{
    @GET("static_api.json")
    suspend fun getHasilZodiak(): List<HasilZodiak>
}

object HasilZodiakApi{
    val service : HasilZodiakApiService by lazy {
        retrofit.create(HasilZodiakApiService::class.java)
    }

    enum class ApiStatus{LOADING, SUCCESS, FAILED}

    fun getHasilZodiakUrl(gambar : String): String{
        return "$BASE_URL$gambar.jpg"
    }
}

