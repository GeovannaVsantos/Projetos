package com.gevi.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevi.sqlcomroom.adapter.UserAdapter
import com.gevi.sqlcomroom.data.MainViewModel
import com.gevi.sqlcomroom.databinding.ActivityMainBinding
import com.gevi.sqlcomroom.databinding.FragmentListFragmentoBinding


class ListFragmento : Fragment() {

    private lateinit var binding: FragmentListFragmentoBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListFragmentoBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        val adapter = UserAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        mainViewModel.selectUser.observe(viewLifecycleOwner){
            response -> adapter.setlist(response)
        }

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmento_to_addFragmento)
        }
        return binding.root

    }
}