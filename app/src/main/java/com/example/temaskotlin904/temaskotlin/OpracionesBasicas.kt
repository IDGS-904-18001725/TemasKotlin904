package com.example.temaskotlin904.temaskotlin

//funciones de calculo
fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun restar(a: Int, b: Int): Int {
    return a - b
}

fun multiplicar(a: Int, b: Int): Int {
    return a * b
}

fun dividir(a: Int, b: Int): Int {
    if (b == 0) {
        println("No se puede dividir entre 0.")
        return 0
    }
    return a / b
}

fun FuncionSumar() {
    println("Ingresa el primer numero")
    val a = readLine()?.toIntOrNull()
    println("Ingresa el segundo numero")
    val b = readLine()?.toIntOrNull()
    if (a != null && b != null) {
        println("La suma de los dos numeros es ${sumar(a, b)}")
    } else {
        println("Entrada inválida.")
    }
}

fun FuncionRestar() {
    println("Ingresa el primer numero")
    val a = readLine()?.toIntOrNull()
    println("Ingresa el segundo numero")
    val b = readLine()?.toIntOrNull()
    if (a != null && b != null) {
        println("La resta de los dos numeros es ${restar(a, b)}")
    } else {
        println("Entrada inválida.")
    }
}

fun FuncionMultiplicacion() {
    println("Ingresa el primer numero")
    val a = readLine()?.toIntOrNull()
    println("Ingresa el segundo numero")
    val b = readLine()?.toIntOrNull()
    if (a != null && b != null) {
        println("La multiplicación de los dos numeros es ${multiplicar(a, b)}")
    } else {
        println("Entrada inválida.")
    }
}

fun FuncionDivision() {
    println("Ingresa el primer numero")
    val a = readLine()?.toIntOrNull()
    println("Ingresa el segundo numero")
    val b = readLine()?.toIntOrNull()
    if (a != null && b != null) {
        println("La división de los dos numeros es ${dividir(a, b)}")
    } else {
        println("Entrada inválida.")
    }
}

fun main() {
    var seleccion: String?
    do {
        println("\nMenu de la calculadora: selecciona una operación")
        println("1.- SUMAR")
        println("2.- RESTAR")
        println("3.- DIVIDIR")
        println("4.- MULTIPLICAR")
        println("5.- SALIR")
        seleccion = readLine()

        when (seleccion) {
            "1" -> FuncionSumar()
            "2" -> FuncionRestar()
            "3" -> FuncionDivision()
            "4" -> FuncionMultiplicacion()
            "5" -> println("salir")
            else -> println("Opción inválida.")
        }
    } while (seleccion != "5")
}
