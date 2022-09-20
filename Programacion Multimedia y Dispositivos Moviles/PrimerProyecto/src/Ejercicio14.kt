fun main () {
    //Ej14
    val ciudades = listOf("Alicante", "Almería", "Barcelona", "Bilbao", "Burgos", "Cádiz", "Cartagena", "Córdoba", "Gerona"
        , "Gijón", "Granada", "Huelva", "Tenerife", "Ibiza", "Jerez", "Madrid", "Málaga", "Marbella", "Murcia", "Oviedo"
        , "Pamplona", "Ronda", "Salamanca", "San Sebastián", "Santander", "Santiago", "Sevilla", "Tarragona", "Toledo",
        "Valencia", "Zaragoza")
    println("Ejercicio 13:")
    println(listasEjercicio1(ciudades))
    println(listasEjercicio2(ciudades))
    println(listasEjercicio3(ciudades))
    println(listasEjercicio4(ciudades))
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