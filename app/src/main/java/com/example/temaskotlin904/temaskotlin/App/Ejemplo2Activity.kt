package com.example.temaskotlin904.temaskotlin.App

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R
import java.util.stream.IntStream.range

class Ejemplo2Activity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var tv1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        edt1 = findViewById<EditText>(R.id.edt1)
        edt2 = findViewById<EditText>(R.id.edt2)
        tv1 = findViewById<TextView>(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun ejecutarActividad2(view: android.view.View) {
        var a: String = "";
        var b: String = "";

        //valida que los valores sean numericos y no sean vacios
        if (edt1.text.toString().isNotEmpty()) {
            a = edt1.text.toString()
        }
        if (edt2.text.toString().isNotEmpty()) {
            b = edt2.text.toString()
        }

        var strNum = b

        for(i in range(1, a.toInt())){
            strNum += " + $b"
        }

        tv1.text = strNum + "=" + multiplicar(a.toDouble(), b.toDouble()).toString()

    }

    fun multiplicar(a: Double = 0.0, b: Double = 0.0): Double {
        return a * b
    }

}