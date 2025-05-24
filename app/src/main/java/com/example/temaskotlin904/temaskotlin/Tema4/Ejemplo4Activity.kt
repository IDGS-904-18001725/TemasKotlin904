package com.example.temaskotlin904.temaskotlin.Tema4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R
import java.io.FileNotFoundException

class Ejemplo4Activity : AppCompatActivity() {
    private val filename = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo5)

        val inputText = findViewById<EditText>(R.id.edt1)
        val outputText = findViewById<TextView>(R.id.outputText)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnGuardar = findViewById<Button>(R.id.saveBtn)
        val btnLeer = findViewById<Button>(R.id.readBtn)

        btnBorrar.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Confirmación")
                setMessage("¿Estás seguro de borrar el contenido?")
                setPositiveButton("Sí") { _, _ ->
                    try {
                        openFileOutput(filename, MODE_PRIVATE).use {
                            it.write("".toByteArray())
                        }
                        // outputText.text?.clear()
                        showToast("Contenido borrado")
                    } catch (e: Exception) {
                        e.printStackTrace()
                        showToast("Error al borrar")
                    }
                }
                setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
                create().show()
            }
        }

        btnGuardar.setOnClickListener {
            val text = inputText.text.toString().takeIf { it.isNotBlank() } ?: run {
                showToast("El texto está vacío")
                return@setOnClickListener
            }

            try {
                openFileOutput(filename, MODE_APPEND).use {
                    it.write("$text\n".toByteArray())
                }
                inputText.text.clear()
                showToast("Texto guardado")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast("Error al guardar")
            }
        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput(filename).bufferedReader().useLines { lines ->
                    lines.joinToString("\n")
                }
                outputText.setText(contenido)
            } catch (e: FileNotFoundException) {
                outputText.setText("")
                showToast("El archivo no existe aún")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast("Error al leer el archivo")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}