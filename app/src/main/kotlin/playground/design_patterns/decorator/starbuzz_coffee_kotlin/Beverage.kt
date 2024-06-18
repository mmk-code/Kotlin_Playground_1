package playground.design_patterns.decorator.starbuzz_coffee_kotlin

interface Beverage {
    val description: String
    fun cost(): Double
}

class Espresso : Beverage {
    override val description = "Espresso"
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage {
    override val description: String = "House Blend Coffee"
    override fun cost(): Double = 0.89
}

class DarkRoast : Beverage {
    override val description: String = "Dark Roast Coffee"
    override fun cost(): Double = 0.99
}

class Decaf : Beverage {
    override val description: String = "Decaf Coffee"
    override fun cost(): Double = 1.05
}

/*
interface Beverage {
    fun getDescription(): String
    fun cost(): Double
}

class Espresso : Beverage {
    private val description = "Espresso"
    override fun getDescription(): String = description
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage {
    private val description: String = "House Blend Coffee"
    override fun getDescription(): String = description
    override fun cost(): Double = 0.89
}

class DarkRoast : Beverage {
    private val description: String = "Dark Roast Coffee"
    override fun getDescription(): String = description
    override fun cost(): Double = 0.99
}

class Decaf : Beverage {
    private val description: String = "Decaf Coffee"
    override fun getDescription(): String = description
    override fun cost(): Double = 1.05
}
*/

/*==================================================*/
