package com.gestorClase.servicio

import com.gestorClase.modelo.Alumno

class ClasificadorAlumnos {

    fun clasificar(alumnos: List<Alumno>): Pair<List<Alumno>, List<Alumno>> {
        val aprobados = mutableListOf<Alumno>()
        val suspensos = mutableListOf<Alumno>()

        alumnos.forEach { alumno ->
            if (alumno.notaFinal != null &&
                alumno.notaFinal!! >= 5.0) {
                aprobados.add(alumno)
            } else {
                suspensos.add(alumno)
            }
        }

        return Pair(aprobados, suspensos)
    }
}