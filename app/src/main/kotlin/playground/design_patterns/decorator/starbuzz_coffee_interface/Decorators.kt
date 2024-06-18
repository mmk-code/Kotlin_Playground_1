package playground.design_patterns.decorator.starbuzz_coffee_interface

/*==================== Interface Implementation =========================*/

//interface CondimentDecorator: Beverage {
//    var beverage: Beverage
//}

class Mocha(private val beverage: Beverage) : Beverage {
    override var description: String = "Mocha"
        get() = beverage.description + ", " + field
    override fun cost() = beverage.cost() + 0.20
}

class Soy(private val beverage: Beverage) : Beverage {
    override var description: String = "Soy"
        get() = beverage.description + ", " + field
    override fun cost() = beverage.cost() + 0.15
}

class Whip(private val beverage: Beverage) : Beverage {

    override var description: String = "Whip"
        get() = beverage.description + ", " + field
    override fun cost() = beverage.cost() + 0.10
}

class Milk(private val beverage: Beverage) : Beverage {
    override var description: String = "Milk"
        get() = beverage.description + ", " + field
    override fun cost() = beverage.cost() + 0.10
}


/*==================== Abstract class Implementation =========================*/

//abstract class CondimentDecorator: Beverage {
//    lateinit var beverage: Beverage
//
//}
//
//class Mocha(beverage: Beverage) : CondimentDecorator() {
//    init {
//        this.beverage = beverage
//    }
//    override var description: String = "Mocha"
//        get() = beverage.description + ", " + field
//    override fun cost() = beverage.cost() + 0.20
//}
//
//class Soy(beverage: Beverage) : CondimentDecorator() {
//    init {
//        this.beverage = beverage
//    }
//    override var description: String = "Soy"
//        get() = beverage.description + ", " + field
//    override fun cost() = beverage.cost() + 0.15
//}
//
//class Whip(beverage: Beverage) : CondimentDecorator() {
//    init {
//        this.beverage = beverage
//    }
//    override var description: String = "Whip"
//        get() = beverage.description + ", " + field
//    override fun cost() = beverage.cost() + 0.10
//}
//
//class Milk(beverage: Beverage) : CondimentDecorator() {
//    init {
//        this.beverage = beverage
//    }
//    override var description: String = "Milk"
//        get() = beverage.description + ", " + field
//    override fun cost() = beverage.cost() + 0.10
//}