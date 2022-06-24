package com.gevi.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevi.test.Adapter.TarefaAdapter
import com.gevi.test.Adapter.TaskClickListener
import com.gevi.test.databinding.FragmentListBinding
import com.gevi.test.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment (), TaskClickListener {
    private lateinit var binding: FragmentListBinding
    private val mainViewMode: MainViewMode by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        mainViewMode.listagem()




        val adapter = TarefaAdapter(this, mainViewMode, requireContext())
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)



        binding.floatingAdd.setOnClickListener{
            mainViewMode.tarefaSelecionada = null // -> As informações da Tarefa selecionada ficaram nulas ao que elas são clicadas
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        mainViewMode.myTarefaResponse.observe(viewLifecycleOwner){
            response -> if(response.body() != null){
                adapter.setList(response.body()!!)
        }
        }

        return binding.root
    }

    override fun onTaskClickListener(tarefa: Tarefa) {
       mainViewMode.tarefaSelecionada = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
    }
}