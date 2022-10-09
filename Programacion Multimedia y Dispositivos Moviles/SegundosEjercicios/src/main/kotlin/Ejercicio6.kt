fun main() {
    val abc = "abcdefghijklmnopqrstuvwxyz"
    val texto = "abcdefghijklmnopqrstuvwxyz"
    var textoCifrado = ""

    val rot = 13

    texto.forEach {
        textoCifrado += abc[getNewIndex(abc.indexOf(it), rot, abc)]
    }

    println("Texto plano: $texto")
    println("Cifrado:     $textoCifrado")
}

fun getNewIndex(index : Int, rot : Int, abc : String) : Int {
    return if (index + rot >= abc.length)
        index - rot
    else
        index + rot
}