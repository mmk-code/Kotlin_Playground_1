package playground.design_patterns.decorator.starbuzz_coffee


enum class Size { TALL, GRANDE, VENTI }

abstract class Beverage(
    private var description: String = "",
    private var size: Size = Size.TALL
) {
    open fun getDescription() = description
    abstract fun cost():Double
}

class Espresso : Beverage("Espresso") {
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage("House Blend Coffee") {
    override fun cost(): Double = 0.89
}

class DarkRoast : Beverage("Dark Roast Coffee") {
    override fun cost(): Double = 0.99
}

class Decaf : Beverage("Decaf Coffee") {
    override fun cost(): Double = 1.05
}

