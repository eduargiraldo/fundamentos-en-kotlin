package com.eduargiraldo.fundamentoskotlin.`reto  4`
class `menu restaurante` {
}
data class Plato(val nombre: String, val descripcion: String, val precio: Double)

fun main() {
    val menu = mutableMapOf<String, MutableList<Plato>>(
        "Entradas" to mutableListOf(),
        "Platos Fuertes" to mutableListOf(),
        "Postres" to mutableListOf(),
        "Bebidas" to mutableListOf()
    )

    var opcion: Int

    do {
        println("----- MENÚ DEL RESTAURANTE -----")
        println("1. Agregar plato")
        println("2. Mostrar todos los platos")
        println("3. Mostrar platos por categoría")
        println("4. Modificar menú")
        println("5. Modificar plato")
        println("6. Eliminar plato")
        println("0. Salir")
        print("Ingrese una opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> agregarPlato(menu)
            2 -> mostrarPlatos(menu)
            3 -> mostrarPlatosPorCategoria(menu)
            4 -> modificarMenu(menu)
            0 -> println("¡Hasta luego!")
            else -> println("Opción inválida. Intente nuevamente.")
        }

        println()
    } while (opcion != 0)
}

fun agregarPlato(menu: MutableMap<String, MutableList<Plato>>) {
    println("----- AGREGAR PLATO -----")
    print("Ingrese la categoría del plato (Entradas, Platos Fuertes, Postres, Bebidas): ")
    val categoria = readLine()?.capitalize() ?: ""
    print("Ingrese el nombre del plato: ")
    val nombre = readLine() ?: ""
    print("Ingrese la descripción del plato: ")
    val descripcion = readLine() ?: ""
    print("Ingrese el precio del plato: ")
    val precio = readLine()?.toDoubleOrNull() ?: 0.0

    val plato = Plato(nombre, descripcion, precio)

    if (menu.containsKey(categoria)) {
        menu[categoria]?.add(plato)
        println("Plato agregado exitosamente.")
    } else {
        println("Categoría inválida. No se pudo agregar el plato.")
    }
}

fun mostrarPlatos(menu: MutableMap<String, MutableList<Plato>>) {
    println("----- PLATOS DEL MENÚ -----")
    for ((categoria, platos) in menu) {
        println("Categoría: $categoria")
        for (plato in platos) {
            println("Nombre: ${plato.nombre}")
            println("Descripción: ${plato.descripcion}")
            println("Precio: ${plato.precio}")
            println("--------------------")
        }
    }
}

fun mostrarPlatosPorCategoria(menu: MutableMap<String, MutableList<Plato>>) {
    println("----- PLATOS POR CATEGORÍA -----")
    print("Ingrese la categoría (Entradas, Platos Fuertes, Postres, Bebidas): ")
    val categoria = readLine()?.capitalize() ?: ""

    if (menu.containsKey(categoria)) {
        val platos = menu[categoria]
        println("Categoría: $categoria")
        for (plato in platos!!) {
            println("Nombre: ${plato.nombre}")
            println("Descripción: ${plato.descripcion}")
            println("Precio: ${plato.precio}")
            println("--------------------")
        }
    } else {
        println("Categoría inválida. No se encontraron platos.")
    }
}

fun modificarMenu(menu: MutableMap<String, MutableList<Plato>>) {
    println("----- MODIFICAR MENÚ -----")
    print("Ingrese la categoría a modificar (Entradas, Platos Fuertes, Postres, Bebidas): ")
    val categoria = readLine()?.capitalize() ?: ""

    if (menu.containsKey(categoria)) {
        print("Ingrese el nuevo nombre de la categoría: ")
        val nuevoNombre = readLine()?.capitalize() ?: ""
        menu[nuevoNombre] = menu.remove(categoria)!!
        println("Categoría modificada exitosamente.")
    } else {
        println("Categoría inválida. No se pudo modificar.")
    }
}