class Personaje(var nombre: String, var perfil: String) {
    var pesoMaxMochila = 10
    var mochila = mutableListOf<Articulo>()

    fun robar(articulos: List<Articulo>) {
        var pesoActualMochla = 0
        var mejor = Articulo(0,0)

        //while (pesoActualMochla <= pesoMaxMochila) {
            articulos.forEach {
                if (it.valor > mejor.valor)
                    if (it.peso <= pesoMaxMochila && pesoActualMochla <= pesoMaxMochila) {
                        mochila.add(it)
                        pesoActualMochla += it.peso
                    }
            }


    }

    override fun toString(): String {
        return "Personaje(nombre='$nombre', perfil='$perfil', tamMochila=$pesoMaxMochila, mochila=$mochila)"
    }
}

class Articulo(var peso: Int, var valor: Int) {

    override fun toString(): String {
        return "peso=$peso, valor=$valor"
    }
}

fun main() {
    var p1 = Personaje("Daniel", "Ladron")

    val articulos = listOf<Articulo>(Articulo(5, 10), Articulo(4, 40), Articulo(6, 30), Articulo(4, 50))

    p1.robar(articulos)

    println(p1)
}