package com.gevi.test

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gevi.test.databinding.FragmentFormBinding
import com.gevi.test.fragment.DatePickerFragment
import com.gevi.test.fragment.TimerPickerListener
import com.gevi.test.model.Catigoria
import com.gevi.test.model.Tarefa
import java.time.LocalDate


class FormFragment : Fragment (), TimerPickerListener {

    private lateinit var binding: FragmentFormBinding
    private val mainViewMode: MainViewMode by activityViewModels()
    private var categoriaSelecionada = 0L
    private var tarefaselecionada: Tarefa? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFormBinding.inflate(layoutInflater, container, false)
        loadData()
        mainViewMode.listCategoria()

        mainViewMode.dataSelecionada.value = LocalDate.now()

        mainViewMode.myCategoriaResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisicao", response.body().toString())
            catigoriapinner(response.body())

            //Recuperar data atual

            mainViewMode.dataSelecionada.observe(viewLifecycleOwner) { selected ->
                binding.editData.setText(selected.toString())

            }


        }

        binding.buttonSalvar.setOnClickListener {
            inserirBanco()

        }


        binding.editData.setOnClickListener {
            DatePickerFragment(this)
                .show(parentFragmentManager, "Date Pick Pick Pick eee")
        }





        return binding.root


    }


    fun catigoriapinner(listCatigoria: List<Catigoria>?) {
        if (listCatigoria != null) {
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listCatigoria
            )

            binding.spinnerCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   val selected = binding.spinnerCategoria.selectedItem as Catigoria

                    categoriaSelecionada = selected.id
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }



        val selected = binding.spinnerCategoria.selectedItem as Catigoria
        categoriaSelecionada = selected.id
    }


    private fun validarcampos(
        nome: String,
        descricao: String,
        responsa: String
    ): Boolean {
        return !(
                (nome == "" || nome.length < 3 || nome.length > 20) ||
                        (descricao == "" || descricao.length < 10 || descricao.length > 280) ||
                        (responsa == "" || responsa.length < 2 || responsa.length > 20)
                )
    }

    fun inserirBanco() {
        val nome = binding.editNome.text.toString()
        val resp = binding.editResponsavel.text.toString()
        val desc = binding.editDescricao.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchAtivoCard.isChecked
        val categoria = Catigoria(categoriaSelecionada, null, null)

        val save: String
        save = "Tarefa Atualizada"

        if (tarefaselecionada != null){
            val tarefa = Tarefa(tarefaselecionada?.id!!, nome,desc,resp,data,status, categoria)
            mainViewMode.uptoDate(tarefa)
        }else {
            val tarefa = Tarefa(tarefaselecionada?.id!!, nome,desc,resp,data, status, categoria)
            mainViewMode.addTarefa(tarefa)
            Toast.makeText(context,save, Toast.LENGTH_LONG ).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        if (validarcampos(nome, desc, resp)) {
            val tarefa = Tarefa(0, nome, resp, desc, data, status, categoria)
            mainViewMode.addTarefa(tarefa)
            Toast.makeText(context, "Tarefa criada", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        } else {
            Toast.makeText(context, "Verifique os campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun loadData(){
        tarefaselecionada = mainViewMode.tarefaSelecionada
        if (tarefaselecionada != null){
            binding.editNome.setText(tarefaselecionada?.nome)
            binding.editDescricao.setText(tarefaselecionada?.descricao)
            binding.editResponsavel.setText(tarefaselecionada?.responsavel)
            binding.editData.setText(tarefaselecionada?.data)
            binding.switchAtivoCard.isChecked = tarefaselecionada?.status!!
        }
    }




    override fun ondataSelected(date: LocalDate) {
        mainViewMode.dataSelecionada.value = date

    }

}



