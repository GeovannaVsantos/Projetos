package com.gevi.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gevi.test.api.Repository
import com.gevi.test.model.Catigoria
import com.gevi.test.model.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewMode @Inject constructor (
    private val repository: Repository): ViewModel() {
    var tarefaSelecionada: Tarefa? = null

    init {
        //listCategoria()
    }


    private val _myCategoriaResponse = MutableLiveData<Response<List<Catigoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Catigoria>>> = _myCategoriaResponse

    val dataSelecionada = MutableLiveData<LocalDate>()

    private val _mytarefaresponse = MutableLiveData<Response<List<Tarefa>>>()
    val myTarefaResponse: LiveData<Response<List<Tarefa>>> = _mytarefaresponse

    fun listCategoria() {
        viewModelScope.launch {

            try {

                val response = repository.ListCategoria()
                _myCategoriaResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addTarefa(tarefa: Tarefa) {
        viewModelScope.launch {

            try {
                repository.addTarefa(tarefa)
                listagem()

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listagem() {
        viewModelScope.launch {
            try {
                val response = repository.listTarefa()
                _mytarefaresponse.value = response
            } catch (e: Exception) {
                Log.d("Error", e.message.toString())

            }
        }
    }

    fun uptoDate(tarefa: Tarefa) {
        viewModelScope.launch {

            try {
                repository.updateTarefa(tarefa)

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun deleteAssigment(id: Long) {
        viewModelScope.launch {
            try {
                repository.deleteWork(id)
                listagem()

            }catch (e:Exception) {
                Log.d("Error", e.message.toString())
            }
        }
    }
}

