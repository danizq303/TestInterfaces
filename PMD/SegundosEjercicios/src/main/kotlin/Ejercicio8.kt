class Personaje2 {
    var nombre = ""
    var raza = ""
    var clase = ""
    var estadoVital = ""

    private var pesoMaxMochila = 10
    private var mochila = mutableListOf<Articulo>()

    var razas = listOf("Elfo", "Humano", "Enano", "Goblin")
    var clases = listOf("Mago", "Ladron", "Guerrero", "Berseker")
    var estadosVitales = listOf("Joven", "Adulto", "Anciano")

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

    fun hablar(pregunta: String) {
        val c1 = "Como estas?"
        var output = ""

        when (estadoVital) {
            estadosVitales[0] -> {
                output = if (pregunta == c1)
                    "De lujo"
                else if (pregunta == pregunta.uppercase()) {
                    if (pregunta.contains('?') || pregunta.contains('??'))
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
                    if (pregunta.contains('?') || pregunta.contains('??'))
                        "Estoy buscando la mejor soluci??n"
                    else
                        "No me levantes la voz mequetrefe"
                } else if (pregunta == nombre)
                    "??Necesitas algo?"
                else
                    "No s?? de qu?? me est??s hablando"
            }

            estadosVitales[2] -> {
                output = if (pregunta == c1)
                    "No me puedo mover"
                else if (pregunta == pregunta.uppercase()) {
                    if (pregunta.contains('?') || pregunta.contains('??'))
                        "Que no te escucho!"
                    else
                        "H??blame m??s alto que no te escucho"
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
        val abc = "abcdefghijklmn??opqrstuvwxyz"
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
    val personaje = Personaje2()

    crearPersonaje(personaje)
    println("Tu personaje es: $personaje")

    println("Pregunta a tu personaje, para dejar de hablar con tu personaje escribe 'Salir'")
    var pregunta = readln()
    while (pregunta != "Salir") {
        personaje.hablar(pregunta)
        println("Pregunta a tu personaje, para dejar de hablar con tu personaje escribe 'Salir'")
        pregunta = readln()
    }

    println("Fin del programa")
}

fun crearPersonaje(personaje: Personaje2) {
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