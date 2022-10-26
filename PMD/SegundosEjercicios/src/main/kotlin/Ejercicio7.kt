import kotlin.random.Random

class Personaje {
    private var pesoMaxMochila = 20
    var mochila = mutableListOf<Articulo>()

    fun robar(articulos: List<Articulo>) {
        var pesoActualMochila = 0
        val aRatios = mutableListOf<Float>()
        var valor = 0

        //En base a el atributo mochila y articulos agregar a la mochila los articulos que se puedan agregar y que sean los mas valiosos
        //Si el peso de la mochila es mayor a 10 no se puede agregar nada
        //Si el peso de la mochila es menor a 10 se puede agregar un articulo
        //Si el peso de la mochila es menor a 10 y el articulo pesa mas de 10 no se puede agregar nada
        //Si el peso de la mochila es menor a 10 y el articulo pesa menos de 10 se puede agregar el articulo
        //Si el peso de la mochila es menor a 10 y el articulo pesa menos de 10 y la suma del peso de la mochila con el articulo es mayor a 10 no se puede agregar nada
        //Si el peso de la mochila es menor a 10 y el articulo pesa menos de 10 y la suma del peso de la mochila con el articulo es menor a 10 se puede agregar el articulo
        //Si el peso de la mochila es menor a 10 y el articulo pesa menos de 10 y la suma del peso de la mochila con el articulo es menor a 10 y el peso de la mochila mas el peso del articulo es mayor a 10 no se puede agregar nada
        //Si el peso de la mochila es menor a 10 y el articulo pesa menos de 10 y la suma del peso de la mochila con el articulo es menor a 10 y el peso de la mochila mas el peso del articulo es menor a 10 se puede agregar el articulo

        if (mochila.sumOf { it.peso } < pesoMaxMochila) {
            for (i in articulos) {
                if (i.peso < pesoMaxMochila) {
                    aRatios.add(i.valor.toFloat() / i.peso.toFloat())
                }
            }
            aRatios.sortDescending()

            for (i in aRatios) {
                for (j in articulos) {
                    if (j.valor.toFloat() / j.peso.toFloat() == i) {
                        if (mochila.sumOf { it.peso } + j.peso <= pesoMaxMochila) {
                            mochila.add(j)
                            valor += j.valor
                            pesoActualMochila += j.peso
                        }
                    }
                }
            }
        }

        imprimirMochila(pesoActualMochila,valor)
    }

    fun robar2(articulos: List<Articulo>) {
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
}

class Articulo {
    var peso: Int = Random.nextInt(1, 20)
    var valor: Int = Random.nextInt(10, 60)
    override fun toString(): String {
        return "peso=$peso, valor=$valor"
    }
}

fun main() {
    var p1: Personaje
    var p2: Personaje
    var articulos = mutableListOf(Articulo(), Articulo(), Articulo(), Articulo(), Articulo(), Articulo())

    articulos.forEach { print("| $it |") }

    println()

      do {
        p1 = Personaje()
        p2 = Personaje()
        articulos = mutableListOf(Articulo(), Articulo(), Articulo(), Articulo(), Articulo(), Articulo())

        println("Primer robo")
        p1.robar(articulos)

        println("Segundo robo")
        p2.robar2(articulos)
    } while (p1.mochila == p2.mochila)
}