package com.gevi.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.cardlayout)
        Log.d("Ciclo", "OnCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("Ciclo", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo", "onPause")
        Toast.makeText( this, "onPausee", Toast.LENGTH_SHORT).show()
    }
}