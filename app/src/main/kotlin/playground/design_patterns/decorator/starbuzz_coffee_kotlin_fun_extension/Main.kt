package playground.design_patterns.decorator.starbuzz_coffee_kotlin_fun_extension


fun main() {
    var beverage: Beverage = Espresso()
    beverage = beverage.add("Milk")
    println(beverage.description + " => $" + beverage.cost())

    println("==== ANOTHER ORDER ====")
    beverage = DarkRoast().addMocha().addMocha().add("Whip")
    println(beverage.description + " => $" + beverage.cost())

    println("==== ANOTHER ORDER ====")
    val beverage3: Beverage = HouseBlend().addSoy().addMocha().addWhip()
    println(beverage3.description + " => $" + beverage3.cost())

    println("==== ANOTHER ORDER ====")
    val beverage4: Beverage = Decaf()
    println(beverage4.description + " => $" + beverage4.cost())
}