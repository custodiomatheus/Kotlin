package com.example.c2

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorro {

    @GET("cachorros")
    fun list(): Call<List<Cachorro>>

    @POST("cachorros")
    fun cadastrar(@Body novoCachorro:Cachorro): Call<Cachorro>

}