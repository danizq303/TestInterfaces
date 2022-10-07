fun main() {
    var lista = listOf<String>("Renault", "Peugeot", "Opel", "Fiat", "SEAT")

    var cochesConA = lista.filter { it.contains('a') }

    println(cochesConA)
}