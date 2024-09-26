package com.gestorClase.servicio

import com.gestorClase.modelo.Alumno

class CalculadoraNotas {

    private fun calcularNotaFinal(alumno: Alumno): Double {
        val notaParcial1 = alumno.parcial1 ?: 0.0
        val notaParcial2 = alumno.parcial2 ?: 0.0
        val notaOrdinario1 = alumno.ordinario1 ?: 0.0
        val notaOrdinario2 = alumno.ordinario2 ?: 0.0
        val notaPracticas = alumno.practicas ?: 0.0
        val notaOrdinarioPracticas = alumno.ordinarioPracticas ?: 0.0
        val notaParciales = (maxOf(notaParcial1, notaOrdinario1) + maxOf(notaParcial2, notaOrdinario2)) / 2
        return (notaParciales * 0.6) + (maxOf(notaPracticas, notaOrdinarioPracticas) * 0.4)
    }

    fun asignarNotaFinal(alumnos: List<Alumno>): List<Alumno> {
        alumnos.forEach { it.notaFinal = calcularNotaFinal(it) }
        return alumnos
    }
}