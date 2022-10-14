class Personaje(var nombre: String, var clase: String) {
    private var pesoMaxMochila = 10
    var mochila = mutableListOf<Articulo>()

    fun robar(articulos: List<Articulo>) {
        var pesoActualMochila = 0
        val aRatios = mutableListOf<Float>()

        articulos.forEach { aRatios.add(it.valor.toFloat() / it.peso.toFloat()) }
        aRatios.sortByDescending { it }

        aRatios.forEach { ratio ->
            articulos.forEach {
                if (it.valor.toFloat() / it.peso == ratio && pesoActualMochila <= pesoMaxMochila)
                    if (pesoActualMochila + it.peso <= pesoMaxMochila) {
                        mochila.add(it)
                        pesoActualMochila += it.peso
                    }
            }
        }

        imprimirMochila(pesoActualMochila)
    }

    private fun imprimirMochila(pesoActual : Int) {
        println("Mochila:")
        mochila.forEach { println(it) }
        println("TAM Actual: $pesoActual, TAM Maximo: $pesoMaxMochila")
    }

    override fun toString(): String {
        return "Personaje(nombre='$nombre', perfil='$clase', mochila=$mochila)"
    }
}

class Articulo(var peso: Int, var valor: Int) {
    override fun toString(): String {
        return "peso=$peso, valor=$valor"
    }
}

fun main() {
    val p1 = Personaje("Daniel", "Ladron")
    val articulos = mutableListOf(Articulo(5, 10), Articulo(4, 40), Articulo(6, 30), Articulo(4, 50))

    p1.robar(articulos)
}