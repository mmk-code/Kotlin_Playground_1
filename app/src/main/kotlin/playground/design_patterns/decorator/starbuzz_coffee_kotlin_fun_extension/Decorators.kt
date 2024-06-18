package playground.design_patterns.decorator.starbuzz_coffee_kotlin_fun_extension

/*==================== Function Extension as Decorator =========================*/

fun Beverage.add(condiment: String): Beverage {
    return object : Beverage {
        val allowedCondiment = listOf("Mocha", "Soy", "Whip", "Milk")
        override var description: String = if (allowedCondiment.contains(condiment)) {
            condiment
        }
        else {
            ""
        }
            get() = this@add.description + ", " + field

        override fun cost(): Double = this@add.cost() + when(condiment) {
            "Mocha" -> 0.20
            "Soy" -> 0.15
            "Whip" -> 0.10
            "Milk" -> 0.10
            else -> 0.0
        }
    }
}

fun Beverage.addMocha(): Beverage {
    return object : Beverage {
        override var description: String = "Mocha"
            get() = this@addMocha.description + ", " + field
        override fun cost(): Double = this@addMocha.cost() + 0.20
    }
}

fun Beverage.addSoy(): Beverage {
    return object : Beverage {
        override var description: String = "Soy"
            get() = this@addSoy.description + ", " + field
        override fun cost(): Double = this@addSoy.cost() + 0.15
    }
}

fun Beverage.addWhip(): Beverage {
    return object : Beverage {
        override var description: String = "Whip"
            get() = this@addWhip.description + ", " + field
        override fun cost(): Double = this@addWhip.cost() + 0.10
    }
}

fun Beverage.addMilk(): Beverage {
    return object : Beverage {
        override var description: String = "Milk"
            get() = this@addMilk.description + ", " + field
        override fun cost(): Double = this@addMilk.cost() + 0.10
    }
}


