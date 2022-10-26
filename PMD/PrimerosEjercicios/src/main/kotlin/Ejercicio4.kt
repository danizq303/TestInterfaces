import kotlin.random.Random

fun main() {
    val lista = listOf("Hola,", 2, 3, "¿", 0.1, "Qué", 1, "tal", 0.9, "?")
    var sumaNumeros = 0.0
    var sumaStrings = ""

    lista.forEach {
        when (it) {
            is Int -> sumaNumeros += it
            is Double -> sumaNumeros += it
            is String -> sumaStrings += "$it "
        }
    }

    println("Suma Numeros: $sumaNumeros")
    println("Suma String: $sumaStrings")
}