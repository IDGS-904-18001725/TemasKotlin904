package com.example.temaskotlin904.temaskotlin

fun main(){
    // Las variables declaradas con 'val' son de solo lectura (no se pueden reasignar)
    val a = 4
    val b = 8

    // Las variables declaradas con 'var' son mutables (pueden cambiar su valor)
    var c = 10

    // Imprime el valor de la variable 'a'
    println(a)  // Resultado: 4

    // Imprime el valor de 'b' con un mensaje usando interpolación de cadenas
    println("el valor de b es $b")  // Resultado: el valor de b es 8

    // Imprime el resultado de sumar 2 a la variable 'c'
    println("el valor de c + 2 es ${c+2}")  // Resultado: el valor de c + 2 es 12

    // Se reasigna 'c' con el valor de 'a' + 2 => 4 + 2 = 6
    c = a + 2

    // Se le suma 8 al valor actual de 'c' => 6 + 8 = 14
    c += 8

    // Se le resta 5 al valor actual de 'c' => 14 - 5 = 9
    c -= 5

    // Esta línea **no tiene efecto** porque no se asigna el resultado a 'c'
    c * 8  // Esto debería ser: c = c * 8 para que tenga efecto

    // Se divide 'c' entre 2 y se guarda el resultado => 9 / 2 = 4 (división entera)
    c /= 2

    // Imprime el valor final de 'c'
    println("el valor de c es $c")  // Resultado: el valor de c es 4

    /*
    Comentario bloqueado con tipos explícitos:

    val num1: Int = 23  // Variable constante tipo entero
    var num2: Int = 12  // Variable mutable tipo entero
    num2 = 6  // Se cambia el valor de num2

    var nombre: String = "Carlos"  // Cadena de texto
    var caracter: Char = 'a'      // Un solo carácter

    var num4: Float = 12.5f       // Número decimal con tipo Float (necesita la 'f' al final)
    var num5: Double = 12.5       // Número decimal con mayor precisión (Double)
    */
}
