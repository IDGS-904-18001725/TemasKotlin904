package com.example.temaskotlin904.temaskotlin.Cine

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temaskotlin904.R

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var cantidadPersonas: EditText
    private lateinit var cantidadBoletos: EditText
    private lateinit var tarjetaCinecoSlection: RadioGroup

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        name = findViewById<EditText>(R.id.idName)

        cantidadPersonas = findViewById<EditText>(R.id.compradoresID)
        cantidadPersonas.setText("1")
        cantidadBoletos = findViewById<EditText>(R.id.idCantidadBoletos)
        cantidadBoletos.setText("1")
        tarjetaCinecoSlection = findViewById<RadioGroup>(R.id.rdGroup)
        tarjetaCinecoSlection.check(R.id.radioNo)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val rowBoletosPrecio = findViewById<TextView>(R.id.rowBoletosPrecio)
        val rowBoletosCantidad = findViewById<TextView>(R.id.rowBoletosCantidad)
        val rowBoletosTotal = findViewById<TextView>(R.id.rowBoletosTotal)

        val rowDescCantBolPorcentaje = findViewById<TextView>(R.id.rowDescCantBolPorcentaje)
        val rowDescCantBolPrecio = findViewById<TextView>(R.id.rowDescCantBolTotal)

        val rowDescCinecoPorcentaje = findViewById<TextView>(R.id.rowDescCinecoPorcentaje)
        val rowDescCinecoPrecio = findViewById<TextView>(R.id.rowDescCinecoPrecio)

        val rowSubtotal = findViewById<TextView>(R.id.rowSubTotal)
        val rowTotal = findViewById<TextView>(R.id.rowTotal)


        val btnValidar = findViewById<Button>(R.id.btnValidar)

        btnValidar.setOnClickListener {
            val ventaBoletos = ClsVentaBoletas()

            val tarjetaCineco = findViewById<RadioButton>(tarjetaCinecoSlection.checkedRadioButtonId)
            ventaBoletos.name = name.text.toString()
            ventaBoletos.cantidadPersonas = cantidadPersonas.text.toString().toInt()
            ventaBoletos.cantidadBoletos = cantidadBoletos.text.toString().toInt()
            ventaBoletos.tarjetaCineco = tarjetaCineco.text.toString()
            ventaBoletos.imprimirConsola()
            if (ventaBoletos.validarDatos()) {
                tableLayout.visibility = View.VISIBLE
                ventaBoletos.calcularPrecioTotal()

                rowBoletosPrecio.text = "$ ${ventaBoletos.__precioBoleto__}"
                rowBoletosCantidad.text = ventaBoletos.cantidadBoletos.toString()
                rowBoletosTotal.text = "$ ${ventaBoletos.cantidadBoletos * ventaBoletos.__precioBoleto__}"

                rowDescCantBolPorcentaje.text = "${ventaBoletos.descuento}%"
                rowDescCantBolPrecio.text = "$ ${ventaBoletos.totalPrimerDescuento}"

                rowDescCinecoPorcentaje.text = "${ventaBoletos.descuentoCineco}%"
                rowDescCinecoPrecio.text = "$ ${ventaBoletos.precioSegundoDescuento}"

                rowSubtotal.text = "$ ${ventaBoletos.precioDescuento}"
                rowTotal.text = "$ ${ventaBoletos.precioFinal}"


            } else {
                Toast.makeText(this, ventaBoletos.mensaje, Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    class ClsVentaBoletas(
        var name: String = "",
        var cantidadPersonas: Int = 1,
        var cantidadBoletos: Int = 1,
        var tarjetaCineco: String = "NO"
    ) {
        var precioTotal: Double = 0.0
        var descuento: Double = 0.0
        var totalPrimerDescuento: Double = 0.0
        var precioDescuento: Double = 0.0
        var descuentoCineco: Double = 0.0
        var precioFinal: Double = 0.0
        var mensaje: String = ""
        var precioSegundoDescuento = 0.0
        val __precioBoleto__: Double = 12.00
        val __maxBoletosPorPersona__: Int = 7

        init {
            Log.d("mensaje", "Inicialización completa")
            imprimirConsola()
        }

        fun Double.redondearDecimales(decimales: Int): Double {
            return "%.${decimales}f".format(this).toDouble()
        }

        fun imprimirConsola() {
            Log.d("mensaje", "Nombre: $name")
            Log.d("mensaje", "Cantidad: $cantidadBoletos")
            Log.d("mensaje", "Tarjeta: $tarjetaCineco")
            Log.d("mensaje", "Precio: $__precioBoleto__")
            Log.d("mensaje", "Total: $precioTotal")
            Log.d("mensaje", "Descuento: $descuento")
            Log.d("mensaje", "Final: $precioFinal")
            Log.d("mensaje", "Mensaje: $mensaje")
        }

        fun calcularDescuentoBoletos(): Double {
            descuento = 0.0
            if (cantidadBoletos > 2 && cantidadBoletos <= 5) {
                descuento+= 10
            }
            if (cantidadBoletos > 5) {
                descuento+= 15
            }
            return descuento
        }

        fun calcularDescuentoCineco(): Double {
            if (tarjetaCineco == "SI") {
                descuentoCineco = 10.00
            }
            return descuentoCineco
        }

        fun calcularPrecioTotal(): Double {
            descuento = calcularDescuentoBoletos()
            descuentoCineco = calcularDescuentoCineco()



            totalPrimerDescuento =((__precioBoleto__ * cantidadBoletos) * (descuento / 100))
            totalPrimerDescuento = totalPrimerDescuento.redondearDecimales(2)

            precioDescuento = ((__precioBoleto__ * cantidadBoletos) - totalPrimerDescuento)
            precioDescuento = precioDescuento.redondearDecimales(2)

            precioTotal = ((__precioBoleto__ * cantidadBoletos))
            precioTotal = precioTotal.redondearDecimales(2)

            precioSegundoDescuento = precioDescuento * (descuentoCineco / 100)
            precioSegundoDescuento = precioSegundoDescuento.redondearDecimales(2)

            precioFinal = precioDescuento - precioSegundoDescuento
            precioFinal = precioFinal.redondearDecimales(2)
            return precioFinal
        }

        fun validarDatos(): Boolean {
            mensaje = ""
            if (name.isEmpty()) {
                mensaje = "Debe ingresar un nombre"
            }
            if (cantidadPersonas == 0) {
                mensaje = "Debe ingresar una cantidad de personas"
            }
            if (cantidadBoletos == 0) {
                mensaje = "Debe ingresar una cantidad de boletos"
            }
            if (cantidadBoletos > (cantidadPersonas * __maxBoletosPorPersona__)) {
                mensaje = "Solo se pueden comprar maximo $__maxBoletosPorPersona__ boletos por persona"
            }
            if (tarjetaCineco.isEmpty()) {
                mensaje = "Debe seleccionar una tarjeta"
            }
            if (cantidadPersonas > cantidadBoletos) {
                mensaje = "Debes comprar almenos un boleto por cada persona"
            }
            return mensaje.isEmpty()
        }

    }

}