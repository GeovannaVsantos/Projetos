package com.gevi.test.api


import com.gevi.test.Util.Constante
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofilterInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constante.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}