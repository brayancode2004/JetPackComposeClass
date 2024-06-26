package com.uam.scheduleapk.repository

import android.util.Log
import com.uam.scheduleapk.remote.ApiAdapter
import com.uam.scheduleapk.remote.ApiUsuario
import retrofit2.Response

class RepositoryUsuario {
    val apiUsuario : ApiUsuario by lazy {
        ApiAdapter.getInstance().create(ApiUsuario :: class.java)
    }

    suspend fun login(email:String,password : String) : Result<Int> {
        val retorno : Int
        return try {
            val response : Response<Int> = apiUsuario.login(email,password)
            retorno = response.body() as Int
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }

}