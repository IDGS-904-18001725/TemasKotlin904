package com.example.temaskotlin904.temaskotlin.PracticaDiccionarios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {

    private lateinit var radioGroupIdioma: RadioGroup
    private lateinit var rbEspanol: RadioButton
    private lateinit var rbIngles: RadioButton
    private lateinit var edtPalabraBuscar: EditText
    private lateinit var btnBuscarPalabra: Button
    private lateinit var tvPalabraEncontrada: TextView
    private lateinit var btnRegresarMenu: Button

    private val FILE_NAME = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        radioGroupIdioma = findViewById(R.id.radioGroupIdioma)
        rbEspanol = findViewById(R.id.rbEspanol)
        rbIngles = findViewById(R.id.rbIngles)
        edtPalabraBuscar = findViewById(R.id.edtPalabraBuscar)
        btnBuscarPalabra = findViewById(R.id.btnBuscarPalabra)
        tvPalabraEncontrada = findViewById(R.id.tvPalabraEncontrada)
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu)

        btnBuscarPalabra.setOnClickListener {
            buscarPalabra()
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

    private fun buscarPalabra() {
        val palabraBuscar = edtPalabraBuscar.text.toString().trim()

        if (palabraBuscar.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa la palabra a buscar.", Toast.LENGTH_SHORT).show()
            return
        }

        val buscarEnEspanol = rbEspanol.isChecked
        val buscarEnIngles = rbIngles.isChecked

        if (!buscarEnEspanol && !buscarEnIngles) {
            Toast.makeText(this, "Selecciona si buscas en Español o Inglés.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val inputStream = openFileInput(FILE_NAME)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var linea: String?
            var encontrada = false
            var palabraTraducida = ""

            while (reader.readLine().also { linea = it } != null) {
                val partes = linea?.split("=")
                if (partes != null && partes.size == 2) {
                    val espanol = partes[0].trim()
                    val ingles = partes[1].trim()

                    if (buscarEnEspanol && espanol.equals(palabraBuscar, ignoreCase = true)) {
                        palabraTraducida = ingles
                        encontrada = true
                        break
                    } else if (buscarEnIngles && ingles.equals(palabraBuscar, ignoreCase = true)) {
                        palabraTraducida = espanol
                        encontrada = true
                        break
                    }
                }
            }
            reader.close()
            inputStream.close()

            if (encontrada) {
                tvPalabraEncontrada.text = palabraTraducida
                tvPalabraEncontrada.visibility = android.view.View.VISIBLE
            } else {
                tvPalabraEncontrada.text = "Palabra no encontrada"
                tvPalabraEncontrada.visibility = android.view.View.VISIBLE
            }

        } catch (e: Exception) {
            tvPalabraEncontrada.text = "Palabra no encontrada"
            tvPalabraEncontrada.visibility = android.view.View.VISIBLE
            Toast.makeText(this, "Error al buscar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}