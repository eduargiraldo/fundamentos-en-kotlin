package com.eduargiraldo.fundamentoskotlin.`reto 1`



class notificacion {
}
fun main() {
    val notificaciones = mapOf(
        "telefono 1" to 50,
        "telefono 2" to 100,
        "telefono 3" to 0
    )

    for ((telefono, contar) in notificaciones) {
        val mensaje = when {
            contar > 0 && contar < 100 -> "$contar notificaciones "
            contar >= 100 -> "99+ notificaciones "
            else -> "No tiene mensajes "
        }
        println("$telefono: $mensaje")
    }
}