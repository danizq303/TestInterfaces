import kotlin.random.Random

class Dado {
    private var numMin = 1
    private var numMax = 6

    constructor()

    constructor(numMin: Int, numMax: Int) {
        this.numMin = numMin
        this.numMax = numMax
    }

    fun tiradaUnica (): Int {
        return Random.nextInt(numMin, numMax)
    }
}

class Jugadores(private var numero: Int) {
    var resultado = 0

    override fun toString(): String {
        return "Jugador $numero ha sacado $resultado"
    }
}

fun main() {
    val dado1 = Dado()
    val dado2 = Dado(1,3)
    val dado3 = Dado(4,6)

    val aJugadores = mutableListOf<Jugadores>()
    repeat(100) {
        aJugadores.add(Jugadores(it))
    }

    aJugadores.forEach {
        repeat(100) {i ->
            it.resultado += dado1.tiradaUnica()
            it.resultado += dado2.tiradaUnica()
            it.resultado += dado3.tiradaUnica()
        }
    }

    val sortedList = aJugadores.sortedWith(compareBy({ it.resultado })).reversed()

    println(mostrarResultado(sortedList))
}

fun mostrarResultado(lista : List<Jugadores>): String {
    return lista.toString()
}