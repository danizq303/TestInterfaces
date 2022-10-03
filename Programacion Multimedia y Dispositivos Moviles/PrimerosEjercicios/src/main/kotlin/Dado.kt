import kotlin.random.Random

class Dado {
    private var numMin = 1
    private var numMax = 6

    constructor()

    constructor(numMin: Int, numMax: Int) {
        this.numMin = numMin
        this.numMax = numMax
    }

    fun tiradaUnica (): Int {
        return Random.nextInt(numMin, numMax)
    }

    fun tiradaDoble (): Int {
        val num1 = Random.nextInt(numMin, numMax)
        //println("num1 = $num1")
        val num2 = Random.nextInt(numMin, numMax)
        //println("num2 = $num2")
        return num1 + num2
    }
}