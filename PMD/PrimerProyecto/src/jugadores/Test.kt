package jugadores

fun main() {
    val lista = mutableListOf<Int>()

    lista.add(2)
    lista.add(2)
    lista.add(4)
    lista.add(5)

    println(lista)

    lista.remove(2)

    println(lista)
}