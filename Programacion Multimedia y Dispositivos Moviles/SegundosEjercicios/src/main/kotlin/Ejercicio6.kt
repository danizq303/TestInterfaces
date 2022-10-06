fun main() {
    val abc = "abcdefghijklmnopqrstuvwxyz"
    val texto = "abcdefghijklmnopqrstuvwxyz"
    var textoCifrado = ""

    val rot = 13

    texto.forEach {
        textoCifrado += abc[getRot(abc.indexOf(it), rot, abc)]
    }

    println(textoCifrado)
}

fun getRot(index : Int, rot : Int, abc : String) : Int {
    return if (index + rot >= abc.length)
        abc.length + index - rot
    else
        index + rot
}

