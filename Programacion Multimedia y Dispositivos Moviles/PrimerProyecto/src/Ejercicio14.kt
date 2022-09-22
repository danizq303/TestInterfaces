import java.io.File
import kotlin.random.Random

fun main () {
    //Ej14
    val ciudades = listOf(
        "Alicante",
        "Almería",
        "Barcelona",
        "Bilbao",
        "Burgos",
        "Cádiz",
        "Cartagena",
        "Córdoba",
        "Gerona",
        "Gijón",
        "Granada",
        "Huelva",
        "Tenerife",
        "Ibiza",
        "Jerez",
        "Madrid",
        "Málaga",
        "Marbella",
        "Murcia",
        "Oviedo",
        "Pamplona",
        "Ronda",
        "Salamanca",
        "San Sebastián",
        "Santander",
        "Santiago",
        "Sevilla",
        "Tarragona",
        "Toledo",
        "Valencia",
        "Zaragoza"
    )
    println("Ejercicio 13:")
    println(listasEjercicio1(ciudades))
    println(listasEjercicio2(ciudades))
    println(listasEjercicio3(ciudades))
    println(listasEjercicio4(ciudades))

    //Ej15
    println("Ejercicio 14:")
    println(listas2Ejercicio1(ciudades))
    println(listas2Ejercicio2(ciudades))

    //Ej16
    val jugador = Jugador()
    /*j1.nombre = "Daniel"
    j1.partidasJugadas = 25
    j1.tiempoJugado = 243
    j1.kills = 25
    j1.deaths = 8*/
    println(jugador.getDetalles())

    //Ej17
    println("Ejercicio 17:")
    val dado1 = Dado()
    val dado2 = Dado()

    dado1.darValores(3, 4)
    dado2.darValores(0, 30)

    println(dado1.tiradaUnica())
    println(dado1.tiradaMultiple())

    println(dado2.tiradaUnica())
    println(dado2.tiradaMultiple())

    //Ej18 (diapo 121)

    //Ej19 (modificacion del 17)

    //Ej20
    println("Ejercicio 20:")

    val jugador1 = Jugador("Alfredo", 15, 21, 24, 20)

    println(jugador1.getDetalles())
    jugador1.guardarJugador()

    val jugador2 = Jugador("Godofredo", 1, 2, 3, 4)
    jugador2.guardarJugador()
    jugador2.kills++
    jugador2.kills++
    jugador2.tiempoJugado++
    println(jugador2.getDetalles())
    jugador2.cargarJugador()
    println(jugador2.getDetalles())
}

//Ej14
fun listasEjercicio1(ciudades : List<String>) : List<String> {
    return ciudades.filter { it.contains("A") || it.contains("a") }
}

fun listasEjercicio2(ciudades : List<String>) : List<String> {
    val listaConAs = listasEjercicio1(ciudades).toMutableList()

    listaConAs.forEachIndexed { pos, it ->
        if (it.contains("A"))
            listaConAs[pos] = it.uppercase()
    }

    return listaConAs
}

fun listasEjercicio3(ciudades : List<String>) : List<String> {
    return ciudades.filter { it.length != 8 }
}

fun listasEjercicio4(ciudades : List<String>) : List<String> {
    val ciudadesMutable = ciudades.toMutableList()

    ciudadesMutable.forEachIndexed {index, it ->
        if (it.length.rem(2) != 0)
            ciudadesMutable[index] = it.reversed()
    }

    return ciudadesMutable
}

//Ej15
fun listas2Ejercicio1(ciudades : List<String>): List<String> {
    return ciudades.filter { it.length.rem(2) == 0 }
}

fun listas2Ejercicio2(ciudades : List<String>): List<String> {
    return ciudades.filter { it.startsWith("A") || it.toCharArray()[1] == 'a' }
}

//Ej16
/*class Jugador {

    var nombre: String
    var partidasJugadas: Int
    var tiempoJugado: Int
    var kills: Int
    var deaths: Int
    init {
        println("Nombre")
        this.nombre = readln()
        println("Partidas Jugadas")
        this.partidasJugadas = readIntFromKeyboard()
        println("Tiempo jugado")
        this.tiempoJugado = readIntFromKeyboard()
        println("Kills")
        this.kills = readIntFromKeyboard()
        println("Deaths")
        this.deaths = readIntFromKeyboard()
    }

    private fun getKD(): Double {
        return kills.toDouble() / deaths.toDouble()
    }

    fun getDetalles(): String {
        return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
    }
}*/

class Jugador(var nombre : String = "",
              var partidasJugadas : Int = 0,
              var tiempoJugado : Int = 0,
              var kills : Int = 0,
              var deaths : Int = 0) {

    private fun getKD(): Double {
        return kills.toDouble() / deaths.toDouble()
    }

    fun getDetalles(): String {
        return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
    }

    fun guardarJugador(){
        val archivo = File("C:/Users/AlumnoM/Documents/DAM2/Programacion Multimedia y Dispositivos Moviles/PrimerProyecto/src/Jugadores/$nombre.txt")
        archivo.writeText("${partidasJugadas}\n")
        archivo.appendText("${tiempoJugado}\n")
        archivo.appendText("${kills}\n")
        archivo.appendText("${deaths}\n")
    }

    fun cargarJugador(){
        try {
            val archivo = File("C:/Users/AlumnoM/Documents/DAM2/Programacion Multimedia y Dispositivos Moviles/PrimerProyecto/src/Jugadores/$nombre.txt")
            val lineas = archivo.readLines()
            partidasJugadas = lineas[0].toInt()
            tiempoJugado = lineas[1].toInt()
            kills = lineas[2].toInt()
            deaths = lineas[3].toInt()
        } catch (exception : Exception) {
            println("Error la leer los datos.")
        }
    }
}

//Ej17
class Dado {
    private var minimo = 0
    private var maximo = 0

    fun darValores(valMin: Int, valMax: Int) {
        if (valMin <= valMax) {
            maximo = valMax
            minimo = valMin
        } else {
            println("Se han cambiado los valores min y maximo")
            maximo = valMin
            minimo = valMax
        }
    }

    fun tiradaUnica(): Int {
        return Random.nextInt(minimo,maximo)
    }

    fun tiradaMultiple(): Int {
        val num1 = Random.nextInt(minimo,maximo)
        val num2 = Random.nextInt(minimo,maximo)

        return if (num1 != num2)
            num1+num2
        else
            num1*num2
    }
}