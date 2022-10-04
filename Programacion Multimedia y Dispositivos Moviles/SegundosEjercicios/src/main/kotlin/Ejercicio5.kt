fun main() {
    var string = "987\n532\n667"

    string = "98\n52\n67"
    val aux = string.toCharArray()

    var row = 1
    var column = 0

    for (c in aux) {
        if (c == '\n')
            row++
        if (row == 1)
            column++
    }

    var cont = 0
    val matriz = Array(row){CharArray(column)}

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

    println("Filas:")
    for(i in 0 until row){
        print("Fila ${i+1}: ")
        for(j in 0 until column){
            print("${matriz[i][j]},")
            print(" ")
        }
        println()
    }

    println()

    println("Columnas:")
    for(i in 0 until column){
        print("Columna ${i+1}: ")
        for(j in 0 until row){
            print("${matriz[j][i]},")
            print(" ")
        }
        println()
    }
}