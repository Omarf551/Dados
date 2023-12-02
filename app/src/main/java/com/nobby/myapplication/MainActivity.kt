package com.nobby.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etDados = findViewById<EditText>(R.id.etDados)
        val etLados = findViewById<EditText>(R.id.etLados)
        val btnTirar = findViewById<Button>(R.id.tirard)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        btnTirar.setOnClickListener {
            val numDados = etDados.text.toString().toIntOrNull()
            val numLados = etLados.text.toString().toIntOrNull()

            if (numDados != null && numLados != null && numDados > 0 && numLados > 0) {
                val resultadoTotal = tirarDados(numDados, numLados)
                tvTotal.text = "Total: $resultadoTotal"
            } else {
                tvTotal.text = "faltan datos"
            }
        }


    }

    private fun tirarDados(numDados: Int, numLados: Int): Int {
        var total = 0
        for (i in 1..numDados) {
            total += Random.nextInt(1, numLados + 1)
        }
        return total
    }
    
    
}