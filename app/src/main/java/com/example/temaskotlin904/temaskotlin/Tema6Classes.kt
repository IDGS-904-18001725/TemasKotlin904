package com.example.temaskotlin904.temaskotlin

class usuarios() {
    val materias: String=""
}

class usuarios2(val Id: Int, val nombre: String){
    val materias: String=""
    fun hola() {
        println("Hola")
    }
}

fun main() {
    val alumno = usuarios2(1, "Carlos")
    val alumno2 = usuarios2(2, "Juan")

    println(alumno2.Id)
    println(alumno2.nombre)
    alumno2.hola()



}