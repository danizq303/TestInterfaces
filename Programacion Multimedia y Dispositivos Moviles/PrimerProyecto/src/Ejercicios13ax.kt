fun main () {
    //Ej13
    println("Ejercicio 13:")
    val list = listOf<Any>("1",2,4)
    val ejercicio1 = { println("Hola")}
    ejercicio1()

    val ejercicio2 = {integer : Int -> println("Hola $integer")}
    ejercicio2(2)

    val ejercicio3 = {integer : Int, listInteger : List<Any> -> println("Hola ${integer + listInteger.size}")}
    ejercicio3(2, list)

    val ejericio4 = {integer : Int, listInteger : List<Any> -> integer + listInteger.size}
    println("El numero es: ${ejericio4(3,list)}")

    //Ej13
    val ciudades = listOf("Alicante", "Almería", "Barcelona", "Bilbao", "Burgos", "Cádiz", "Cartagena", "Córdoba", "Gerona"
        , "Gijón", "Granada", "Huelva", "Tenerife", "Ibiza", "Jerez", "Madrid", "Málaga", "Marbella", "Murcia", "Oviedo"
        , "Pamplona", "Ronda", "Salamanca", "San Sebastián", "Santander", "Santiago", "Sevilla", "Tarragona", "Toledo",
        "Valencia", "Zaragoza")
    println("Ejercicio 13:")
    println(listasEjercicio1(ciudades))
    println(listasEjercicio2(ciudades))
    println(listasEjercicio3(ciudades))
}

//Ej13
fun ejercicio1() {
    println("Hola")
}

fun ejercicio2(integer : Int) {
    println("Hola $integer")
}

fun ejercicio3(integer : Int, listInteger : List<Any>) {
    println("Hola ${integer + listInteger.size}")
}

fun ejercicio4(integer : Int, listInteger : List<Any>) : Int {
    return integer + listInteger.size
}

//Ej14
fun listasEjercicio1(ciudades : List<String>) : List<String> {
    val listaConA = mutableListOf<String>()

    ciudades.forEach() {
        if (it.lowercase().contains('a'))
            listaConA.add(it)
    }

    return listaConA
}

fun listasEjercicio2(ciudades : List<String>) : List<String> {
    val listaConA = mutableListOf<String>()

    ciudades.forEach() {
        if (it.contains('A'))
            listaConA.add(it.uppercase())
        else if (it.lowercase().contains('a'))
            listaConA.add(it)
    }

    return listaConA
}

fun listasEjercicio3(ciudades : List<String>) : List<String> {
    val lista8 = mutableListOf<String>()

    ciudades.forEach() {
        if (it.length != 8)
            lista8.add(it)
    }

    return lista8
}

fun listasEjercicio4(ciudades : List<String>) : List<String> {
    val lista = mutableListOf<String>()

    ciudades.forEach() {
        if (it.length % 2 != 0)
            lista.add(it.reversed())
        else
            lista.add(it)
    }

    return lista
}