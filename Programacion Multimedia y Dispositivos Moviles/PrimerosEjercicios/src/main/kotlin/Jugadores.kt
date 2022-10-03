class Jugadores(var nombre : String) {
    var kills = 0
    var deaths = 0

    override fun toString(): String {
        return "$nombre, kills=$kills, deaths=$deaths"
    }
}