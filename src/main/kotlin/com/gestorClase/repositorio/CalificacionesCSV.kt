package com.gestorClase.repositorio

import com.gestorClase.modelo.Alumno
import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Path
import java.text.DecimalFormatSymbols

class CalificacionesCSV {

    fun leerCalificaciones(rutaFichero: Path): List<Alumno> {
        val alumnos = mutableListOf<Alumno>()
        val br: BufferedReader = Files.newBufferedReader(rutaFichero)
        var firstLineRead = false
        val symbols = DecimalFormatSymbols.getInstance()

        br.use {
            it.forEachLine { linea ->
                if (firstLineRead) {
                    val columnas = linea.split(";")
                    val alumno = Alumno(
                        apellidos = columnas[0],
                        nombre = columnas[1],
                        asistencia = columnas[2].replace("%", "").toDouble() / 100,
                        parcial1 = if (columnas[3].isBlank()) null else columnas[3].replace(',', symbols.decimalSeparator).toDouble(),
                        parcial2 = if (columnas[4].isBlank()) null else columnas[4].replace(',', symbols.decimalSeparator).toDouble(),
                        ordinario1 = if (columnas[5].isBlank()) null else columnas[5].replace(',', symbols.decimalSeparator).toDouble(),
                        ordinario2 = if (columnas[6].isBlank()) null else columnas[6].replace(',', symbols.decimalSeparator).toDouble(),
                        practicas = if (columnas[7].isBlank()) null else columnas[7].replace(',', symbols.decimalSeparator).toDouble(),
                        ordinarioPracticas = if (columnas[8].isBlank()) null else columnas[8].replace(',', symbols.decimalSeparator).toDouble(),
                    )
                    alumnos.add(alumno)
                } else {
                    firstLineRead = true
                }
            }
        }

        //Uso sortedBy para ordenar la lista de alumnos por su atributo apellido
        return alumnos.sortedBy { it.apellidos }
    }
}