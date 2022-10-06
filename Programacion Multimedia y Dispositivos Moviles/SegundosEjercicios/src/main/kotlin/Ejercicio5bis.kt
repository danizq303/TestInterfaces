fun main() {
    var string = "987\n532\n667"
    var string2 = "92\n2\n12"

    var matriz = ArrayList<ArrayList<Char>>()
    var aux = ArrayList<Char>()
    string.forEach {
        if (it == '\n') {
            matriz.add(aux)
            for (c in aux)
                aux.remove(c)
        } else
            aux.add(it)
    }

    for (array in matriz)
        for (c in array)
            println(c)

    //imprimirFilas(matriz,row,column)

    //println()

    //imprimirColumnas(matriz,row,column)
}


fun imprimirFilas(matriz: List<CharArray>, row: Int, column: Int) {
    println("Filas:")


    //Primera linea
    print("    ")
    for (i in 0 until column)
        print(" ${i + 1} ")

    println()
    //segunda linea
    print("   |")
    for (i in 0 until column)
        print("---")

    println()

    for (i in 0 until row) {
        print(" ${i + 1} |")
        for (j in 0 until column) {
            print(" ${matriz[i][j]}")
            print(" ")
        }
        println()
    }
}

fun imprimirColumnas(matriz: List<CharArray>, row: Int, column: Int) {
    println("Columnas:")

    //Primera linea
    print("    ")
    for (i in matriz.indices)
        print(" ${i + 1} ")

    println()
    //segunda linea
    print("   |")
    for (i in matriz.indices)
        print("---")

    println()

    for (i in 0 until column) {
        print(" ${i + 1} |")
        for (j in 0 until row) {
            print(" ${matriz[j][i]}")
            print(" ")
        }
        println()
    }
}