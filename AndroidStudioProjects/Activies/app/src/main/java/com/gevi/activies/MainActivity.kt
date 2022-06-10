package com.gevi.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butaoir = findViewById<Button>(R.id.butao1)
        val intentSegunda = Intent(this, SegundaActivity :: class.java)
        butaoir.setOnClickListener { startActivity(intentSegunda) }
    }
}