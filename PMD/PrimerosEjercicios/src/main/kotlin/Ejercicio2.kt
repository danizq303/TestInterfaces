fun main() {
    val dado1 = Dado()
    val dado2 = Dado(1,3)
    val dado3 = Dado(4,6)

    val aJugadores = mutableListOf<Jugador>()
    repeat(100) {
        aJugadores.add(Jugador(it))
    }

    aJugadores.forEach {
        repeat(100) {i ->
            it.resultado += dado1.tiradaUnica()
            it.resultado += dado2.tiradaUnica()
            it.resultado += dado3.tiradaUnica()
        }
    }

    println(mostrarResultado(aJugadores))
}

fun mostrarResultado(lista : List<Jugador>): String {
    return lista.sortedByDescending { it.resultado }.toString()
}