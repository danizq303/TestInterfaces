fun main() {
    val string ="9 8\n" +
            "5 2\n" +
            "6 7\n" +
            "4 2"
    val aux = string.filter { it != ' ' }

    imprimirFila(aux)

    println()

    imprimirColumna(aux)
}

fun getFila() {
    
}

fun imprimirFila(matriz: String) {
    println("Filas:")

    println("Columnas:")

    matriz.forEach {
        if (it == '\n')
            println()
        else
            print(" $it ")
    }
}

fun imprimirColumna(matriz: String) {
    println("Columnas:")

    matriz.forEach {
        if (it == '\n')
            println()
        else
            print(" $it ")
    }
}

