package playground.design_patterns.abstract_factory.pizza_factory

interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): List<Veggies>
    fun createPepperoni(): Pepperoni
    fun createClam(): Clams
}
/*==============================*/
class NYPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough {
        return ThinCrustDough()
    }

    override fun createSauce(): Sauce {
        return MarinaraSauce()
    }

    override fun createCheese(): Cheese {
        return ReggianoCheese()
    }

    override fun createVeggies(): List<Veggies> {
        val veggies = listOf(
            Garlic(),
            Onion(),
            Mushroom(),
            RedPepper()
        )
        return veggies
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clams {
        return FreshClams()
    }
}
/*==============================*/
class ChicagoPizzaIngredientFactory: PizzaIngredientFactory {
    override fun createDough(): Dough {
        return ThickCrustDough()
    }

    override fun createSauce(): Sauce {
        return PlumTomatoSauce()
    }

    override fun createCheese(): Cheese {
        return MozzarellaCheese()
    }

    override fun createVeggies(): List<Veggies> {
        val veggies = listOf(
            BlackOlives(),
            Spinach(),
            Eggplant()
        )

        return veggies
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clams {
        return FrozenClams()
    }
}