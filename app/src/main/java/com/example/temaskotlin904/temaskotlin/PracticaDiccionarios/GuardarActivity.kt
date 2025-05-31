package com.example.temaskotlin904.temaskotlin.PracticaDiccionarios

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GuardarActivity : AppCompatActivity() {

    private lateinit var edtEspanol: EditText
    private lateinit var edtIngles: EditText
    private lateinit var btnGuardarPalabra: Button
    private lateinit var btnRegresarMenu: Button
    private lateinit var tvMensajeGuardado: TextView

    private val FILE_NAME = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_guardar)

        edtEspanol = findViewById(R.id.edtEspanol)
        edtIngles = findViewById(R.id.edtIngles)
        btnGuardarPalabra = findViewById(R.id.btnGuardarPalabra)
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu)
        tvMensajeGuardado = findViewById(R.id.tvMensajeGuardado)

        btnGuardarPalabra.setOnClickListener {
            guardarPalabra()
        }

        btnRegresarMenu.setOnClickListener {
            val intent = Intent(this, DiccionarioActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun guardarPalabra() {
        val espanol = edtEspanol.text.toString().trim()
        val ingles = edtIngles.text.toString().trim()

        if (espanol.isEmpty() || ingles.isEmpty()) {
            Toast.makeText(this, "Por favor ingesa ambas palabras.", Toast.LENGTH_SHORT).show()
            return
        }

        val palabra = "$espanol=$ingles\n"

        try {
            val osw = OutputStreamWriter(openFileOutput(FILE_NAME, Context.MODE_APPEND))
            osw.write(palabra)
            osw.flush()
            osw.close()

            tvMensajeGuardado.text = "Palabras Guardadas con éxito"
            tvMensajeGuardado.visibility = android.view.View.VISIBLE

            edtEspanol.text.clear()
            edtIngles.text.clear()

        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}