package com.gestorClase.servicio

import com.gestorClase.modelo.Alumno

class ClasificadorAlumnos {

    fun clasificar(alumnos: List<Alumno>): Pair<List<Alumno>, List<Alumno>> {
        val aprobados = mutableListOf<Alumno>()
        val suspensos = mutableListOf<Alumno>()

        alumnos.forEach { alumno ->
            val notaParcial1 = alumno.parcial1 ?: 0.0
            val notaParcial2 = alumno.parcial2 ?: 0.0
            val notaOrdinario1 = alumno.ordinario1 ?: 0.0
            val notaOrdinario2 = alumno.ordinario2 ?: 0.0
            val notaPracticas = alumno.practicas ?: 0.0
            val notaOrdinarioPracticas = alumno.ordinarioPracticas ?: 0.0

            if (alumno.notaFinal != null &&
                alumno.notaFinal!! >= 5.0 &&
                alumno.asistencia >= 0.75 &&
                maxOf(notaParcial1, notaOrdinario1) >= 4 &&
                maxOf(notaParcial2, notaOrdinario2) >= 4 &&
                maxOf(notaPracticas, notaOrdinarioPracticas) >= 4
                ) {
                aprobados.add(alumno)
            } else {
                suspensos.add(alumno)
            }
        }

        return Pair(aprobados, suspensos)
    }
}