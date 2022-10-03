class Jugador(private var numero: Int) {
    var resultado = 0

    override fun toString(): String {
        return "Jugador $numero ha sacado $resultado"
    }
}