package playground.design_patterns.strategy.duck

interface QuackBehaviour {
    fun quack()
}

class Quack: QuackBehaviour {
    override fun quack() {
        println("Sound is Quacking")
    }
}


