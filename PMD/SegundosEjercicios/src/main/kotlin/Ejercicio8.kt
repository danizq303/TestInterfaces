class Personaje2(
    private var nombre: String,
    private var raza: String,
    var clase: String,
    private var estadoVital: String
) {

    fun hablar(pregunta: String) {
        val c1 = "Como estas?"
        var output = ""

        when (estadoVital) {
            "Joven" -> {
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

            "Adulto" -> {
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

            "Anciano" -> {
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
}

fun main() {
    val p1 = Personaje2("Jack", "Elfo", "Mago", "Anciano")
    val p2 = Personaje2("Jack", "Enano", "Mago", "Adulto")
    val p3 = Personaje2("Jack", "Goblin", "Mago", "Joven")

    p1.hablar("Jack")
    p2.hablar("Como estas?")
    p3.hablar("Como estas?")
}