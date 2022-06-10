package com.gevi.viewanddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gevi.viewanddata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var camadaView: CamadaView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        camadaView = ViewModelProvider(this).get(CamadaView::class.java)
     camadaView.cont.observe(this){
         binding.textResultado.text = it.toString()
     }



        binding.buttonClique.setOnClickListener {
            camadaView.addNum()




        }

    }
}