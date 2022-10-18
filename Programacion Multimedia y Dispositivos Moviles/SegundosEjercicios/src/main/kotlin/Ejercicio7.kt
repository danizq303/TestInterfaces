import kotlin.random.Random

class Personaje(private var nombre: String, private var clase: String) {
    private var pesoMaxMochila = 10
    private var mochila = mutableListOf<Articulo>()

    fun robar(articulos: List<Articulo>) {
        var pesoActualMochila = 0
        val aRatios = mutableListOf<Float>()
        var valor = 0

        articulos.forEach { aRatios.add(it.valor.toFloat() / it.peso.toFloat()) }
        aRatios.sortByDescending { it }

        aRatios.forEach { ratio ->
            articulos.forEach {
                if (it.valor.toFloat() / it.peso.toFloat() == ratio && pesoActualMochila <= pesoMaxMochila)
                    if (pesoActualMochila + it.peso <= pesoMaxMochila) {
                        mochila.add(it)
                        pesoActualMochila += it.peso
                        valor += it.valor
                    }
            }
        }

        val valorMax = articulos.maxOf { it.valor }
        if (valorMax > valor) {
            mochila.clear()
            articulos.forEach {
                if (it.valor == valorMax) {
                    mochila.add(it)
                    valor = valorMax
                    pesoActualMochila = it.peso
                }
            }
        }

        imprimirMochila(pesoActualMochila,valor)
    }

    private fun imprimirMochila(pesoActual: Int,valor : Int) {
        println("Mochila:")
        mochila.forEach { println(it) }
        println("TAM Actual: $pesoActual, TAM Maximo: $pesoMaxMochila, VALOR Actual $valor")
    }

    override fun toString(): String {
        return "Personaje(nombre='$nombre', perfil='$clase', mochila=$mochila)"
    }
}

class Articulo {
    var peso: Int = Random.nextInt(1, 10)
    var valor: Int = Random.nextInt(10, 60)
    override fun toString(): String {
        return "peso=$peso, valor=$valor"
    }
}

fun main() {
    val p1 = Personaje("Daniel", "Ladron")
    val articulos = mutableListOf(Articulo(), Articulo(), Articulo(), Articulo())

    articulos.sortByDescending { it.valor }
    articulos.forEach { print("| $it |") }

    println()

    p1.robar(articulos)
}