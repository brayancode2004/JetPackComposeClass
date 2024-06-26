package com.uam.scheduleapk.repository

import android.util.Log
import com.uam.scheduleapk.model.ListAgenda
import com.uam.scheduleapk.remote.ApiAdapter
import com.uam.scheduleapk.remote.ApiAgenda
import com.uam.scheduleapk.remote.ApiUsuario
import retrofit2.Response

class RepositoryAgenda {

    val apiAgenda : ApiAgenda by lazy {
        ApiAdapter.getInstance().create(ApiAgenda :: class.java)
    }

    suspend fun getAll() : Result<ListAgenda> {
        val retorno : ListAgenda
        return try {
            val response : Response<ListAgenda> = apiAgenda.getAll()
            retorno = response.body() as ListAgenda
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }
}