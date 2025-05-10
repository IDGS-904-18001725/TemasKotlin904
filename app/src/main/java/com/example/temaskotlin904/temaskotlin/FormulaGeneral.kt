package com.example.temaskotlin904.temaskotlin
import kotlin.math.sqrt

fun main() {
    println("Calculadora de la Formula General")

    var a: Double
    do {
        print("Ingresa el valor de a ( 0): ")
        val entrada = readLine()
        a = entrada?.toDoubleOrNull() ?: Double.NaN
        if (a == 0.0 || a.isNaN()) {
            println("Valor del segundo numero no puede ser 0 y debe ser un numero.")
        }
    } while (a == 0.0 || a.isNaN())

    print("Ingresa el valor de b: ")
    val b = readLine()?.toDoubleOrNull() ?: run {
        println("Entrada invalida para b. Terminando programa.")
        return
    }

    // Leer y validar el tercer valor
    print("Ingresa el valor de c: ")
    val c = readLine()?.toDoubleOrNull() ?: run {
        println("Entrada invalida para c. Terminando programa.")
        return
    }

    val discriminante = b * b - 4 * a * c

    if (discriminante < 0) {
        println("La ecuacion no tiene soluciones reales (discriminante < 0).")
    } else {
        val raiz = sqrt(discriminante)
        val x1 = (-b + raiz) / (2 * a)
        val x2 = (-b - raiz) / (2 * a)

        if (x1 == x2) {
            println("La ecuación tiene una solucion real doble: x = $x1")
        } else {
            println("Las soluciones de la ecuacion son:")
            println("x1 = $x1")
            println("x2 = $x2")
        }
    }
}
