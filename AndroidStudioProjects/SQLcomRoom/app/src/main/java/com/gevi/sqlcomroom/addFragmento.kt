package com.gevi.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gevi.sqlcomroom.data.MainViewModel
import com.gevi.sqlcomroom.data.Usuario
import com.gevi.sqlcomroom.databinding.FragmentAddFragmentoBinding


class addFragmento : Fragment() {

    private lateinit var binding: FragmentAddFragmentoBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAddFragmentoBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button2.setOnClickListener {
            inserirBanco()
        }

        return binding.root

    }
    fun verificarCampo (nome: String, sobrenome: String, idade: String) : Boolean {
        return !(nome == "" || sobrenome == "" || idade == "")

    }
    fun inserirBanco (){
        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()

        if (verificarCampo(nome, sobrenome, idade)){
            val user = Usuario(0, nome, sobrenome, idade.toInt())

        mainViewModel.addUser(user)
            Toast.makeText(context, "Usuario Adicionado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragmento_to_listFragmento)

        } else {
            Toast.makeText(context, "Preencha os campos", Toast.LENGTH_LONG).show()
        }
    }

    }
