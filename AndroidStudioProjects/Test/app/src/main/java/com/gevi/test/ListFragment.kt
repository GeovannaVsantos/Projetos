package com.gevi.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevi.test.Adapter.TarefaAdapter
import com.gevi.test.databinding.FragmentListBinding
import com.gevi.test.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment () {
    private lateinit var binding: FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)



        val listTarefas = listOf(
            Tarefa(
                "Lavar a louça",
                "Lavar toda louça",
                "Gevi",
                "2022 - 06 - 07",
                false,
            "Lazer"
            ),
            Tarefa(
                "Limpar o chão",
                "Chão sala e cozinha",
                "Gevi",
                "10 - 06 - 2022",
                false,
                "Na força do odio"
            )


        )

        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        binding

        return binding.root
    }
}