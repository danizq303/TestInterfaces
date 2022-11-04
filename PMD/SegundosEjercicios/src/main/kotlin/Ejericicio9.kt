import kotlin.random.Random

class Dado {
    private var numMin = 0
    private var numMax = 10

    fun darValores(valMin: Int, valMax: Int) {
        if (valMin <= valMax) {
            numMax = valMax
            numMin = valMin
        } else {
            println("Se han cambiado los valores min y maximo")
            numMax = valMin
            numMin = valMax
        }
    }

    fun tiradaUnica(): Int {
        return Random.nextInt(numMin, numMax)
    }

    fun tiradaDoble(): Int {
        val num1 = Random.nextInt(numMin, numMax)
        println("num1 = $num1")
        val num2 = Random.nextInt(numMin, numMax)
        println("num2 = $num2")
        return if (num1 == num2) num1 * num2 else num1 + num2
    }
}

class Articulo2 {
    var peso: Int = Random.nextInt(1, 20)
    var valor: Int = Random.nextInt(10, 120)
    override fun toString(): String {
        return "| peso=$peso, valor=$valor |"
    }
}

class Personaje3 {
    var nombre = ""
    var raza = ""
    var clase = ""
    var estadoVital = ""
    var coins = mutableMapOf<Int, Int>()
    var art = mutableListOf<Articulo2>()

    private var pesoMaxMochila = Dado().tiradaUnica() * 10
    var mochila = mutableListOf<Articulo2>()

    var razas = listOf("Elfo", "Humano", "Enano", "Goblin")
    var clases = listOf("Mago", "Ladron", "Guerrero", "Berseker", "Mercader")
    var estadosVitales = listOf("Joven", "Adulto", "Anciano")

    private var puermaCoins = listOf(1, 5, 10, 25, 100)

    init {
        puermaCoins.forEach { coins[it] = 0 }
    }

    fun robar(articulos: List<Articulo2>) {
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

        imprimirMochila(pesoActualMochila, valor)
    }

    fun tradear(mercader: Personaje3, articulos: List<Articulo2>) {
        articulos.forEach { art.add(it) }

        if (mercader.clase == clases[4]) {
            var num: Int
            val articulosVender = mutableListOf<Articulo2>()

            do {
                println("Cuantos Articulos deseas tradear (1 - Uno, 2 - Varios)")
                num = readln().toInt()
            } while (num != 1 && num != 2)

            if (num == 1) {
                println("Que articulo deseas vender")
                articulos.forEachIndexed { index, articulo2 -> println("$index - $articulo2") }
                articulosVender.add(articulos[readln().toInt()])
            } else {
                println("Cuantos articulos deseas vender (MAX:${articulos.size})")
                var numArticulos = readln().toInt()

                while (numArticulos > 0) {
                    println("Que articulo deseas vender")
                    art.forEachIndexed { index, articulo2 -> println("$index - $articulo2") }
                    val i = readln().toInt()

                    articulosVender.add(art[i])
                    art.removeAll { it == art[i] }
                    mercader.mochila.add(articulosVender.last())

                    numArticulos--
                }
            }

            darDinero(articulosVender)
        } else
            println("No puedes tradear con un no mercader")
    }

    private fun darDinero(articulosVender: List<Articulo2>) {
        var dineroADar: Int

        articulosVender.forEach { art ->
            dineroADar = 0
            puermaCoins.sortedDescending().forEach { moneda ->
                while (dineroADar <= art.valor && art.valor - dineroADar >= moneda) {
                    coins[moneda] = coins[moneda]!! + 1
                    dineroADar += moneda
                }
            }
        }
    }

    private fun imprimirMochila(pesoActual: Int, valor: Int) {
        println("Mochila:")
        mochila.forEach { println(it) }
        println("TAM Actual: $pesoActual, TAM Maximo: $pesoMaxMochila, VALOR Actual $valor")
    }

    fun hablar(pregunta: String) {
        val c1 = "Como estas?"
        var output = ""

        when (estadoVital) {
            estadosVitales[0] -> {
                output = if (pregunta == c1)
                    "De lujo"
                else if (pregunta == pregunta.uppercase()) {
                    if (pregunta.contains('?') || pregunta.contains('¿'))
                        "Tranqui se lo que hago"
                    else
                        "Eh, relajate"
                } else if (pregunta == nombre)
                    "Que pasa?"
                else
                    "Yo que se"
            }

            estadosVitales[1] -> {
                output = if (pregunta == c1)
                    "En la flor de la vida, pero me empieza a doler la espalda"
                else if (pregunta == pregunta.uppercase()) {
                    if (pregunta.contains('?') || pregunta.contains('¿'))
                        "Estoy buscando la mejor solución"
                    else
                        "No me levantes la voz mequetrefe"
                } else if (pregunta == nombre)
                    "¿Necesitas algo?"
                else
                    "No sé de qué me estás hablando"
            }

            estadosVitales[2] -> {
                output = if (pregunta == c1)
                    "No me puedo mover"
                else if (pregunta == pregunta.uppercase()) {
                    if (pregunta.contains('?') || pregunta.contains('¿'))
                        "Que no te escucho!"
                    else
                        "Háblame más alto que no te escucho"
                } else if (pregunta == nombre)
                    "Las 5 de la tarde"
                else
                    "En mis tiempos esto no pasaba"
            }
        }

        when (raza) {
            "Elfo" -> output = cifradoRot(output, 4)
            "Enano" -> output = output.uppercase()
            "Goblin" -> output = cifradoRot(output, 1)
        }

        println(output)
    }

    private fun cifradoRot(texto: String, rot: Int): String {
        val abc = "abcdefghijklmnñopqrstuvwxyz"
        var textoCifrado = ""

        return if (rot == 0)
            texto
        else {
            texto.forEach {
                if (it.isLetter()) textoCifrado += abc[getNewIndex(abc.indexOf(it.lowercase()), rot, abc)]
            }
            textoCifrado
        }
    }

    private fun getNewIndex(index: Int, rot: Int, abc: String): Int {
        return if (index + rot >= abc.length)
            index - rot
        else
            index + rot
    }

    override fun toString(): String {
        return "Personaje2(nombre='$nombre', raza='$raza', clase='$clase', estadoVital='$estadoVital')"
    }
}

fun main() {
    val articulos = mutableListOf(Articulo2(), Articulo2(), Articulo2(), Articulo2(), Articulo2(), Articulo2())

    val personaje = defaultPersonaje()
    //crearPersonaje(personaje)

    val mercader = defaultMercader()
    //crearPersonaje(mercader)

    println("Monedas p1: ${personaje.coins}")

    //personaje.robar(articulos)
    personaje.tradear(mercader, articulos)

    println("Monedas: ${personaje.coins}")
    println("Articulos del Mercader: ${mercader.mochila}")
    println("Articulos restantes: ${personaje.art}")
}

fun crearPersonaje(personaje: Personaje3) {
    println("Introducte su nombre:")
    personaje.nombre = readLine()!!

    do {
        println("Introducte su raza ${personaje.razas}:")
        personaje.raza = readLine()!!
    } while (personaje.raza !in personaje.razas)

    do {
        println("Introducte su clase: ${personaje.clases}")
        personaje.clase = readLine()!!
    } while (personaje.clase !in personaje.clases)

    do {
        println("Introducte su estado vital: ${personaje.estadosVitales}")
        personaje.estadoVital = readLine()!!
    } while (personaje.estadoVital !in personaje.estadosVitales)
}

fun defaultPersonaje(): Personaje3 {
    val personaje = Personaje3()
    personaje.nombre = "Daniel"
    personaje.raza = "Humano"
    personaje.clase = "Mago"
    personaje.estadoVital = "Joven"

    return personaje
}

fun defaultMercader(): Personaje3 {
    val personaje = Personaje3()
    personaje.nombre = "Merca"
    personaje.raza = "Humano"
    personaje.clase = "Mercader"
    personaje.estadoVital = "Joven"

    return personaje
}