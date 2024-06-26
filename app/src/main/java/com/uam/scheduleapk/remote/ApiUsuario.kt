package com.uam.scheduleapk.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUsuario {

    @GET("usuario/login")
    suspend fun login(@Query("email") email : String,
                      @Query("password") password : String): Response<Int>
}