package com.gestorClase.servicio

import com.gestorClase.repositorio.CalificacionesCSV
import java.nio.file.Path

class GestorCalificaciones(
    private val csvManager: CalificacionesCSV,
    private val calculadoraNotas: CalculadoraNotas,
    private val clasificador: ClasificadorAlumnos
) {

    fun ejecutar(rutaFichero: Path) {
        val alumnos = csvManager.leerCalificaciones(rutaFichero)
        val alumnosConNotas = calculadoraNotas.asignarNotaFinal(alumnos)
        val (aprobados, suspensos) = clasificador.clasificar(alumnosConNotas)

        println("Alumnos aprobados:")
        aprobados.forEach { println("${it.nombre} ${it.apellidos}: Nota final = ${it.notaFinal}") }

        println("\nAlumnos suspensos:")
        suspensos.forEach { println("${it.nombre} ${it.apellidos}: Nota final = ${it.notaFinal}") }
    }
}