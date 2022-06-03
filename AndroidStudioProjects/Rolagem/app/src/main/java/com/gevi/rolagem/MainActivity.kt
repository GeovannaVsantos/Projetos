package com.gevi.rolagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaod6 =findViewById<Button>(R.id.d6)
        val botaod12 = findViewById<Button>(R.id.d12)
        val botaod20 = findViewById<Button>(R.id.d20)


        botaod6.setOnClickListener { Toast.makeText( this, "Rodando d6", Toast.LENGTH_SHORT).show()
        rpgRodagemSeis() }

        botaod12.setOnClickListener { Toast.makeText( this,"Rodar D12", Toast.LENGTH_SHORT).show()
        rpgdoze() }

        botaod20.setOnClickListener { Toast.makeText(this, "Rodando d20", Toast.LENGTH_LONG).show()
        rpgvinte() }
    }
    private fun rpgRodagemSeis () {
        val resultado = (1..6).random()
        val textoResultado = findViewById<TextView>(R.id.textInicial)
        textoResultado.text = resultado. toString()

    }
    private fun rpgdoze () {
        val resultados = (1..12).random()
        val textoResultado = findViewById<TextView>(R.id.textInicial)
        textoResultado.text = resultados.toString()
    }
    private fun rpgvinte () {
        val resultados = (1..20).random()
        val textoresultado = findViewById<TextView>(R.id.textInicial)
        textoresultado.text = resultados.toString()
    }
}
