package playground.design_patterns.decorator.starbuzz_coffee_kotlin

/*
Note: Delegator class works with interface not abstract class.

 */

// Decorator Classes
// by-clause is not necessary in decorator if the decorator class provide
// complete implementation of the interface in our case the Beverage interface.
// But if decorator class is partially implemented then the interface require the by-clause.
class Mocha(private val beverage: Beverage) : Beverage by beverage {
    override val description = beverage.description + ", Mocha"
    override fun cost() = beverage.cost() + 0.20
}

class Soy(private val beverage: Beverage) : Beverage by beverage {
    override val description = beverage.description + ", Soy"
    override fun cost() = beverage.cost() + 0.15
}

class Whip(private val beverage: Beverage) : Beverage by beverage {
    override val description = beverage.description + ", Whip"
    override fun cost() = beverage.cost() + 0.10
}

class Milk(private val beverage: Beverage) : Beverage by beverage {
    override val description = beverage.description + ", Milk"
    override fun cost() = beverage.cost() + 0.10
}