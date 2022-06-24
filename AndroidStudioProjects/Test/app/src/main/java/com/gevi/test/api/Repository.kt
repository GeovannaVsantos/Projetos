package com.gevi.test.api

import com.gevi.test.model.Catigoria
import com.gevi.test.model.Tarefa
import retrofit2.Response

class Repository {
    suspend fun ListCategoria () : Response<List<Catigoria>> {
        return RetrofilterInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa> {
        return RetrofilterInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefa(): Response<List<Tarefa>> {
        return RetrofilterInstance.api.listTarefa()

    }
    suspend fun updateTarefa(tarefa: Tarefa) : Response<Tarefa> {
        return RetrofilterInstance.api.uptodateTarefa(tarefa)
    }
    suspend fun deleteWork(id: Long): Response<Tarefa> {
        return RetrofilterInstance.api.deleteTarefa(id)
    }
}
