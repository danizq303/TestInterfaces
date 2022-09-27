fun main(args: Array<String>) {
    crearRascacielos(10, 4, 2)
}

fun crearRascacielos(numeroPisos: Int, numeroVentanas: Int, numeroTorres: Int) {
    val tamTorre = numeroVentanas * 3 + 2

    //print roof
    repeat(numeroTorres) {
        repeat(tamTorre) {
            print('_')
        }
        repeat(tamTorre) {
            print(' ')
        }
    }

    println()

    repeat(numeroPisos) {
        repeat(numeroTorres) {
            print('|')
            repeat(numeroVentanas) {
                print("_N_")
            }
            print('|')

            repeat(tamTorre) {
                print(' ')
            }
        }
        println()
    }



}