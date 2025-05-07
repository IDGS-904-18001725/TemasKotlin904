package com.example.temaskotlin904.temaskotlin

/*
    - List: Lista inmutable (no se puede modificar)
    - MutableList: Lista mutable (puedes agregar, quitar, modificar elementos)
    - MutableSet: Conjunto mutable (sin elementos duplicados, pero se puede modificar)
    - Map: Mapa inmutable (pares clave-valor que no se pueden cambiar)
    - MutableMap: Mapa mutable (pares clave-valor que sí se pueden cambiar)
    ---------------------------------------------------
*/
fun main() {
    

    // Lista inmutable de figuras geométricas
    val readOnlyFiguras = listOf("Cuadrado", "Triángulo", "Círculo")
    println(readOnlyFiguras)  // Imprime la lista

    var figura: MutableList<String> = mutableListOf("Cuadrado", "Triángulo", "Círculo")

    // Lista inmutable (nueva variable con el mismo contenido)
    val readOnlyFiguras2 = listOf("Cuadrado", "Triángulo", "Círculo")

    // Asigna una lista mutable a una variable de tipo List<String> (es válido)
    val mutableFigura: List<String> = figura

    // Conjunto inmutable (sin duplicados)
    val frutas = setOf("Manzana", "Banana", "Naranja")
    val frutas2 = mutableSetOf("Manzana", "Banana", "Naranja")

    // Mapa inmutable
    val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches)  // Imprime: {uno=1, dos=2, tres=3}

    // Mapa mutable
    val coches2 = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches2)  // Imprime lo mismo, pero sí se puede modificar
}