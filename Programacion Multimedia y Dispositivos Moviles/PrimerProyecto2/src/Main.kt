fun main() {
    //Ej1
    println("Ejercicio 1:")
    println(transformaIntADouble(4))
    println(diHola("Dani"))
    println(diEdad("Dani",19))

    //Ej2
    println("Ejercicio 2:")
    println(sumaIntegers(4,5))
    println(sumaString("4","5"))
    diResultado()

    //Ej3
    println("Ejercicio 3:")
    println(calcualrPrecio1(17,"Dani"))

    //Ej4
    println("Ejercicio 4:")
    println(calcualrPrecio2(17,"Dani"))

    //Ej5
    println("Ejercicio 5:")
    println(numPos(4))
    println(esPar(6))

    //Ej6
    println("Ejercicio 6:")
    mostrarChars(10)

    //Ej8
    println("Ejercicio 8:")
    dibujaTorre(10,4)
    println()
    dibujarPiramide(9)

    //Ej9
    println("Ejercicio 9:")
    juegoAvinar(0..9)
}

fun transformaIntADouble(num : Int) : Double {
    return num.toDouble()
}

fun diHola(nombre : String) : String {
    return "Hola $nombre"
}

fun diEdad(nombre : String, anyo : Int) : String {
    return "Soy $nombre, y tengo $anyo anyos"
}

//Ej2
fun sumaIntegers(num1 : Int, num2 : Int) : Double {
    return (num1 + num2).toDouble()
}

fun sumaString(num1 : String, num2 : String) : Double {
    return (num1.toInt() + num2.toInt()).toDouble()
}
 fun diResultado() {
     println("sumaIntegers ha devuelto un ${sumaIntegers(4,5)} ySumaStrings ha devuelto un ${sumaString("4","5")}")
 }

//Ej3
fun calcualrPrecio1(edad : Int, nombre : String) : String {
    val result : String
    if (edad < 18)
        result = "$nombre, debes abonar 5$"
    else if (edad in 18..65)
        result = "$nombre, debes abonar 10$"
    else
        result = "$nombre, para ti es gratis"

    return result
}

//Ej4
fun calcualrPrecio2(edad : Int, nombre : String) : String {
    val result : String
    when {
        edad < 18 -> result = "$nombre, debes abonar 5$"
        edad in 18..65 -> result = "$nombre, debes abonar 10$"
        else -> result = "$nombre, para ti es gratis"
    }

    return result
}

//Ej5
fun numPos(num : Int) : Int {
    return if (num == 0)
        num
    else if (num > 0)
        num * 2 + 3
    else
        num / 2 - 3
}

fun esPar(num : Int) {
    if (num % 2 == 0)
        println("$num es par")
    else
        println("$num es impar")
}

//Ej6
fun mostrarChars(num : Int ) {
    repeat(num) {
        if (it % 10 == 0)
            println()

        print(it.toChar())
    }
}

//Ej7
fun funcion1(num1 : Int?, num2 : Int?, num3 : Int?, num4 : Int?) : Int? {
    return if (num1 == null || num2 == null || num3 == null || num4 == null)
        null
    else
        num1 + num2 + num3 + num4
}

fun funcion2(num1 : Int?, num2 : Int?, num3 : Int?, num4 : Int?) : Int {
    var suma = 0
    suma += num1 ?: 0
    suma += num2 ?: 0
    suma += num3 ?: 0
    suma += num4 ?: 0

    return suma
}

fun funcion3(num1 : Int?, num2 : Int?, num3 : Int?, num4 : Int?) : Int? {

    return if (num1 == null && num2 == null && num3 == null && num4 == null)
        null
    else {
        var suma = num1 ?: 0
        suma += num2 ?: 0
        suma += num3 ?: 0
        suma += num4 ?: 0
        suma
    }
}

//Ej8
fun dibujaTorre(pisos : Int, ventanas : Int) {
    repeat(10 + ventanas) {
        print('_')
    }

    println()

    repeat(pisos) {
        print('|')
        repeat(ventanas) {
            print("_N_")
        }
        println('|')
    }
}

fun dibujarPiramide(lado : Int) {
    repeat(lado) {
        repeat(lado - it) {
            print(' ')
        }

        print('/')

        repeat(it) {
            print("__")
        }

        println('\\')
    }
}

//Ej9
fun juegoAvinar(rango : IntRange) {
    println("Encuentra un numero entre $rango")
    val numeroBuscado = rango.random()

    do {
        println("Escribe tu numero")
        val opcionUsuario = readIntFromKeyboard()
        val encontrado = when {
            numeroBuscado > opcionUsuario -> {
                println("El numero buscado es mas grande")
                false
            }
            numeroBuscado < opcionUsuario -> {
                println("El numero buscado es mas peque")
                false
            }
            else -> {
                println("Enhorabuena! El numero era $numeroBuscado")
                true
            }
        }
    } while (!encontrado)
}

fun readIntFromKeyboard(): Int {
    var result : Int?
    do {
        val selectedOption = readLine()
        result = try {
            selectedOption?.toInt()
        } catch (e: NumberFormatException) {
            println("Lo que has introducido no es un número.")
            null
        }
    } while (result == null)
    return result
}