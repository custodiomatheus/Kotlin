package com.example.c2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApi {

    fun criar(): ApiCachorro {
        return Retrofit.Builder()
                .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/") // URL Base da API
                .addConverterFactory(GsonConverterFactory.create()) // quem será o "conversor" JSON <=> Classe
                .build()
                .create(ApiCachorro::class.java)
    }

}