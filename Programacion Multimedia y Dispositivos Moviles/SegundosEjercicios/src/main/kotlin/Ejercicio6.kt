fun main() {

    val texto = "Ser o no ser, esa es la cuestión."
    val rot = 0

    println("Texto plano: $texto")
    println("Cifrado:     ${cifradoRot(texto, rot)}")
}

fun cifradoRot(texto: String, rot: Int): String {
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

fun getNewIndex(index: Int, rot: Int, abc: String): Int {
    return if (index + rot >= abc.length)
        index - rot
    else
        index + rot
}