package com.example.temaskotlin904.temaskotlin.App

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        radioGroup = findViewById<RadioGroup>(R.id.rg)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


}

    fun ejecutar(view: android.view.View) {
        var opcionSelection = radioGroup.checkedRadioButtonId
        var a = 0.0;
        var b = 0.0;

        //valida que los valores sean numericos y no sean vacios
        if (et1.text.toString().isNotEmpty()) {
            a = et1.text.toString().toDouble()
        }
        if (et2.text.toString().isNotEmpty()) {
            b = et2.text.toString().toDouble()
        }

        if (opcionSelection != -1) {
            var opcionSeleccionada = findViewById<RadioButton>(opcionSelection)
            var texto = opcionSeleccionada.text.toString()
            when (texto) {
                "Sumar" -> tv1.text = sumar(a, b).toString()
                "Restar" -> tv1.text = restar(a, b).toString()
                "Multiplicacion" -> tv1.text = multiplicar(a, b).toString()
                "Division" -> tv1.text = dividir(a, b).toString()
            }
        }
    }

    fun sumar(a: Double = 0.0, b: Double = 0.0): Double {
        return a + b
    }
    fun restar(a: Double = 0.0, b: Double = 0.0): Double {
        return a - b
    }
    fun multiplicar(a: Double = 0.0, b: Double = 0.0): Double {
        return a * b
    }
    fun dividir(a: Double = 0.0, b: Double = 0.0): Double {
        return a / b
    }

    fun irASegundaPantalla(view: View) {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

}