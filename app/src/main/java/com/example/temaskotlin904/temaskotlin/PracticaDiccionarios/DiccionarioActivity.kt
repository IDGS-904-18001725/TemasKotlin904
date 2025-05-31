package com.example.temaskotlin904.temaskotlin.PracticaDiccionarios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R

class DiccionarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        btnGuardar.setOnClickListener {
            val intent = Intent(this, GuardarActivity::class.java)
            startActivity(intent)
        }

        btnBuscar.setOnClickListener {
            val intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}