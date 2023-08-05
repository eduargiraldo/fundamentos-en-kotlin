package com.eduargiraldo.fundamentoskotlin.`reto 2`

class `reproductor musica` {
}
class Album(val numcancion: Int, val tipo: String) {
    val canciones = mutableListOf<cancion>()

    fun addSong(titulo: String, artista: String, año: Int, reproducciones: Int) {
        canciones.add(cancion(titulo, artista, año, reproducciones))
    }

    fun cancionpopular() {
        var maxreproducciones= 0
        var canciopopular: cancion? = null

        for (cancion in canciones ) {
            if (cancion.reproducciones > maxreproducciones) {
                maxreproducciones= cancion.reproducciones
                canciopopular= cancion
            }
        }

        if (canciopopular != null) {
            println("La canción más popular es ${canciopopular.titulo} con $maxreproducciones reproducciones.")
        }
    }

    fun popularidadcanción() {
        for (cancion in canciones) {
            if (cancion.reproducciones >= 1000) {
                println("${cancion.titulo} es popular con ${cancion.reproducciones} reproducciones.")
            } else {
                println("${cancion.titulo} no es popular con ${cancion.reproducciones} reproducciones.")
            }
        }
    }

    fun descripcioncancion () {
        for (cancion in canciones) {
            println("${cancion.titulo}, interpretada por ${cancion.artista}, fue lanzada en ${cancion.año}, ${cancion.reproducciones} reproducciones.")
        }
    }
}

class cancion(val titulo: String, val artista: String, val año: Int, var reproducciones: Int)

fun main() {
    val album = Album(10, "Pop")
    var agregarOtraCancion = true

    do {
        print("Ingrese el título de la canción: ")
        val titulo = readLine()!!

        print("Ingrese el artista de la canción: ")
        val artista = readLine()!!

        print("Ingrese el año en que se lanzó la canción: ")
        val año = readLine()!!.toInt()

        print("Ingrese el número de reproducciones de la canción: ")
        val reproducciones = readLine()!!.toInt()

        album.addSong(titulo, artista, año, reproducciones)

        print("¿Desea agregar otra canción? (s/n): ")
        val input = readLine()!!.toLowerCase()

        agregarOtraCancion = input == "s"
    } while (agregarOtraCancion)

    album.cancionpopular()
    album.popularidadcanción()
    album.descripcioncancion()
}

