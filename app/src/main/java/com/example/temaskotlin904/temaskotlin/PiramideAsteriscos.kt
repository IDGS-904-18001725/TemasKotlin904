package com.example.temaskotlin904.temaskotlin

fun dibujarPiramide(n: Int) {
    var i = 1
    do {
        var j = 1
        do {
            print("*")
            j++
        } while (j <= i)
        println()
        i++
    } while (i <= n)
}

fun main() {
    var numero: Int

    do {
        println("Ingresa un numero para la piramide de asteriscos (0 para salir):")
        val entrada = readLine()
        numero = entrada?.toIntOrNull() ?: -1

        if (numero > 0) {
            dibujarPiramide(numero)
        } else if (numero != 0) {
            println("Numero invalido. Intenta de nuevo.")
        }

    } while (numero != 0)

    println("Programa terminado.")
}
