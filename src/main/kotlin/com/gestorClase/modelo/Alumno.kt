package com.gestorClase.modelo


// Uso data class en vez de diccionario porque me parece una manera más efectiva de guardar la información
data class Alumno(
    val apellidos: String,
    val nombre: String,
    val asistencia: Double,
    val parcial1: Double? = null,
    val parcial2: Double? = null,
    val ordinario1: Double? = null,
    val ordinario2: Double? = null,
    val practicas: Double? = null,
    val ordinarioPracticas: Double? = null,
    var notaFinal: Double? = null
)