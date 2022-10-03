fun main() {
    println("Numero de partidas a realizar")
    val numPartidas = readln().toInt()

    val jugador1 = Jugadores("Jugador1")
    val jugador2 = Jugadores("Jugador2")

    repeat(numPartidas) {
        pelear(jugador1, jugador2)
    }

    println(jugador1)
    println(jugador2)
}

fun pelear(jugador1: Jugadores, jugador2: Jugadores) {
    val dado = Dado()

    val num1 = dado.tiradaDoble()
    println("${jugador1.nombre} ha sacado $num1")

    val num2 = dado.tiradaDoble()
    println("${jugador2.nombre} ha sacado $num2")

    if (num1 > num2) {
        println("Gana ${jugador1.nombre}\n")
        jugador1.kills++
        jugador2.deaths++
    } else if (num2 > num1) {
        println("Gana ${jugador2.nombre}\n")
        jugador2.kills++
        jugador1.deaths++
    } else {
        println("Empate, se repite la partida\n")
        pelear(jugador1, jugador2)
    }
}
