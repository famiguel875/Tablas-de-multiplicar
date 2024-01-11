import java.util.*

/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min: Int, max: Int): Int {
    val scanner = Scanner(System.`in`)
    var numero: Int

    while (true) {
        print("Introduzca un número entre $min y $max: ")

        try {
            numero = scanner.nextInt()
            if (numero in min..max) {
                break
            } else {
                println("**Error** Número fuera de rango. Inténtelo de nuevo.")
            }
        } catch (e: InputMismatchException) {
            println("**Error** Número no válido. Inténtelo de nuevo.")
            scanner.nextLine() // Limpiar el buffer del scanner
        }
    }

    return numero
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no.
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text: String): Boolean {
    val scanner = Scanner(System.`in`)
    var respuesta: String

    while (true) {
        print("$text (s/n): ")
        respuesta = scanner.nextLine().trim().lowercase()

        if (respuesta == "s" || respuesta == "si") {
            return true
        } else if (respuesta == "n" || respuesta == "no") {
            return false
        } else {
            println("**Respuesta no válida** Inténtelo de nuevo.")
        }
    }
}

/**
 * Genera y muestra la tabla de multiplicar para el número dado.
 *
 * @param numero Int - Número para el cual se generará la tabla de multiplicar
 */
fun generarTablaMultiplicar(numero: Int) {
    println("La tabla de multiplicar del número $numero es:")
    for (i in 1..10) {
        println("$i -> $numero × $i = ${numero * i}")
    }
}

fun main() {
    do {
        val numero = pedirNum(1, 100)
        generarTablaMultiplicar(numero)
    } while (pregunta("¿Desea generar otra tabla de multiplicación?"))
}