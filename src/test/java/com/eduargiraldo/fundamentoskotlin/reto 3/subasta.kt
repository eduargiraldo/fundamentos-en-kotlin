package com.eduargiraldo.fundamentoskotlin.`reto 3`

class subasta {
}
fun main() {
    val precioBase = 100000
    val preciosOfertados = mutableListOf<Int>()

    println("se inicia la subasta para el cofre el precio base es  $precioBase")

    do {
        print("Ingrese un precio ofertado para el cofre  (0 para finalizar): ")
        val precioOfertado = readLine()?.toIntOrNull()
        if (precioOfertado != null && precioOfertado > 0) {
            preciosOfertados.add(precioOfertado)
        }
    } while (precioOfertado != null && precioOfertado > 0)

    if (preciosOfertados.isNotEmpty()) {
        val precioMasAlto = preciosOfertados.maxOrNull() ?: precioBase
        println("El precio más alto ofertado es:$precioMasAlto felicitaciones usted gano  ")
    } else {
        println("No se realizaron ofertas. El artículo se vende a la casa de subastas al precio mínimo.")
    }
}

























