package com.gevi.test.model

data class Catigoria (
    var id: Long,
    var descricao: String?,
    var tarefas: List<Tarefa>?
    ) {

    override fun toString(): String {
        return descricao!!
    }
}