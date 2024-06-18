package playground.design_patterns.decorator.starbuzz_coffee

/*==================================================*/

abstract class CondimentDecorator: Beverage() {
    lateinit var beverage: Beverage
    abstract override fun getDescription(): String
}

class Mocha(beverage: Beverage?) : CondimentDecorator() {
    init {
        this.beverage = beverage!!
    }

    override fun getDescription() = beverage.getDescription() + ", Mocha"
    override fun cost() = beverage.cost() + 0.20
}

class Soy(beverage: Beverage?) : CondimentDecorator() {
    init {
        this.beverage = beverage!!
    }

    override fun getDescription() = beverage.getDescription() + ", Soy"
    override fun cost() = beverage.cost() + 0.15
}

class Whip(beverage: Beverage?) : CondimentDecorator() {
    init {
        this.beverage = beverage!!
    }

    override fun getDescription() = beverage.getDescription() + ", Whip"
    override fun cost() = beverage.cost() + 0.10
}

class Milk(beverage: Beverage?) : CondimentDecorator() {
    init {
        this.beverage = beverage!!
    }

    override fun getDescription() = beverage.getDescription() + ", Milk"
    override fun cost() = beverage.cost() + 0.10
}