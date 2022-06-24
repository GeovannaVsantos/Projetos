package com.gevi.test.api

import com.gevi.test.model.Catigoria
import com.gevi.test.model.Tarefa
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Catigoria>>

    @POST("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @GET("tarefa")
    suspend fun listTarefa(): Response<List<Tarefa>>

    @PUT("tarefa")
    suspend fun uptodateTarefa(
        @Body tarefa: Tarefa ): Response<Tarefa>


    @DELETE("tarefa/{id}")
    suspend fun deleteTarefa(
        @Path("id") id: Long
    ) : Response<Tarefa>
}