package playground.design_patterns.decorator.starbuzz_coffee_kotlin_fun_extension


enum class Size { TALL, GRANDE, VENTI }

interface Beverage {
    var description: String
    fun cost():Double
}

class Espresso : Beverage {
    override var description: String = "Espresso"
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage {
    override var description: String = "House Blend Coffee"
    override fun cost(): Double = 0.89
}

class DarkRoast : Beverage {
    override var description: String = "Dark Roast Coffee"
    override fun cost(): Double = 0.99
}

class Decaf : Beverage {
    override var description: String = "Decaf Coffee"
    override fun cost(): Double = 1.05
}

