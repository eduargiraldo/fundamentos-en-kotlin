package com.eduargiraldo.fundamentoskotlin.`reto 5`
import java.util.Random
import java.util.Scanner
class nequi {
}
fun main() {
    val telefonoR :Int= 31231012
    val contraR :Int= 1212
    var saldo : Double= 8500.00
    var salir = false

    println("Por favor ingrese su numero telefonico")
    var telefono : Int = readln().toInt()
    println("Por favor ingrese su contraseña")
    var contra : Int = readln().toInt()

    if (telefono == telefonoR && contra ==contraR)
    do {
        println("Bienvenido a nequi")
        println("El valor de tu cuenta es: $saldo")
        println("Opciones de nequi")
        println("1. Sacar")
        println("2. Enviar")
        println("3. Recargar")
        println("4. Salir")
        println("Por favor digite la opción que usted desee")

        var eleccion: Int
        eleccion = Scanner(System.`in`).nextInt()

        when (eleccion) {
            1 -> {
                if (saldo >= 2000) {
                    println("Por favor digite la suma que quiere retirar:")
                    val sacarSaldo: Double = Scanner(System.`in`).nextDouble()
                    if (sacarSaldo <= saldo) {
                        val codigo = (1000..9999).random()
                        val Rsaldo = saldo - sacarSaldo
                        println("Su código de verificación es: $codigo\nPor seguridad, no comparta este código con nadie.")
                        println("Su saldo actualizado es: $Rsaldo")
                        saldo = Rsaldo
                    } else {
                        println("No tiene suficiente saldo para realizar esta transacción")
                    }
                } else {
                    println("Su saldo es menor a 2000, no puede realizar esta transacción")
                }
            }
            2 -> {
                if (saldo >= 2000) {
                    println("Por favor digite el número de teléfono del usuario al cual le quiere enviar dinero:")
                    val Nenviar: Int = Scanner(System.`in`).nextInt()
                    println("Por favor digite la cantidad de dinero que desea enviar:")
                    val pEnviar: Double = Scanner(System.`in`).nextDouble()
                    if (pEnviar <= saldo) {
                        println("El número al cual se le va a enviar el dinero es: $Nenviar\nY el valor que se va a enviar es: $pEnviar")
                        val sobro = saldo - pEnviar
                        println("Su saldo actualizado es: $sobro")
                        saldo = sobro
                    } else {
                        println("No tiene suficiente saldo para realizar esta transacción")
                    }
                } else {
                    println("Su saldo es menor a 2000, no puede realizar esta transacción")
                }
            }
            3 -> {
                println("Por favor digite el valor de su recarga:")
                val recargar: Double = Scanner(System.`in`).nextDouble()
                println("¿Confirma el valor de la recarga? (si/no)")
                val decision: String = Scanner(System.`in`).next()
                if (decision == "si") {
                    val Vsaldo = recargar + saldo
                    println("El valor de su saldo es: $Vsaldo")
                    saldo = Vsaldo
                } else {
                    println("Usted no confirmó la acción")
                    println("El valor de su saldo es: $saldo")
                }
            }
            4 -> {
                println("Saliendo...\n:))")
                salir = true
            }
            else -> {
                println("Opción inválida")
            }
        }
    } while (!salir)
}