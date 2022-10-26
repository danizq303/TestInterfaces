fun main() {
    var string = "987\n532\n667"

    string ="9 8\n" +
            "5 2\n" +
            "6 7\n" +
            "4 2"
    val aux = string.filter { it != ' ' }.toCharArray()

    var row = 1
    var column = 0

    //Ver tam Array
    for (c in aux) {
        if (c == '\n')
            row++
        if (row == 1)
            column++
    }

    var cont = 0
    val matriz = Array(row){CharArray(column)}

    //Crear Array
    for (i in 0 until row) {
        for (j in 0 until column) {
            if (aux[cont] != '\n')
                matriz[i][j] = aux[cont]
            else {
                cont++
                matriz[i][j] = aux[cont]
            }

            cont++
        }
    }

    imprimirFilas(matriz,row,column)

    println()

    imprimirColumnas(matriz,row,column)
}

fun imprimirFilas(matriz: Array<CharArray>, row: Int, column: Int) {
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

    for(i in 0 until row){
        print(" ${i+1} |")
        for(j in 0 until column){
            print(" ${matriz[i][j]}")
            print(" ")
        }
        println()
    }
}

fun imprimirColumnas(matriz: Array<CharArray>, row: Int, column: Int) {
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

    for(i in 0 until column){
        print(" ${i+1} |")
        for(j in 0 until row){
            print(" ${matriz[j][i]}")
            print(" ")
        }
        println()
    }
}