package playground.design_patterns.decorator.starbuzz_coffee_interface


fun main() {
    var beverage: Beverage = Espresso()
    beverage = Milk(beverage)
    println(beverage.description + " $" + beverage.cost())

    var beverage2: Beverage = DarkRoast()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println(beverage2.description + " $" + beverage2.cost())

    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println(beverage3.description + " $" + beverage3.cost())

    var beverage4: Beverage = Decaf()
    println(beverage4.description + " $" + beverage4.cost())
}