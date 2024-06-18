package playground.design_patterns.abstract_factory.pizza_factory

interface PizzaIngredientFactory {
    fun createDough(): playground.design_patterns.abstract_factory.pizza_factory.Dough
    fun createSauce(): playground.design_patterns.abstract_factory.pizza_factory.Sauce
    fun createCheese(): playground.design_patterns.abstract_factory.pizza_factory.Cheese
    fun createVeggies(): List<playground.design_patterns.abstract_factory.pizza_factory.Veggies>
    fun createPepperoni(): playground.design_patterns.abstract_factory.pizza_factory.Pepperoni
    fun createClam(): playground.design_patterns.abstract_factory.pizza_factory.Clams
}
/*==============================*/
class NYPizzaIngredientFactory : playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory {
    override fun createDough(): playground.design_patterns.abstract_factory.pizza_factory.Dough {
        return playground.design_patterns.abstract_factory.pizza_factory.ThinCrustDough()
    }

    override fun createSauce(): playground.design_patterns.abstract_factory.pizza_factory.Sauce {
        return playground.design_patterns.abstract_factory.pizza_factory.MarinaraSauce()
    }

    override fun createCheese(): playground.design_patterns.abstract_factory.pizza_factory.Cheese {
        return playground.design_patterns.abstract_factory.pizza_factory.ReggianoCheese()
    }

    override fun createVeggies(): List<playground.design_patterns.abstract_factory.pizza_factory.Veggies> {
        val veggies = listOf<playground.design_patterns.abstract_factory.pizza_factory.Veggies>(
            playground.design_patterns.abstract_factory.pizza_factory.Garlic(),
            playground.design_patterns.abstract_factory.pizza_factory.Onion(),
            playground.design_patterns.abstract_factory.pizza_factory.Mushroom(),
            playground.design_patterns.abstract_factory.pizza_factory.RedPepper()
        )
        return veggies
    }

    override fun createPepperoni(): playground.design_patterns.abstract_factory.pizza_factory.Pepperoni {
        return playground.design_patterns.abstract_factory.pizza_factory.SlicedPepperoni()
    }

    override fun createClam(): playground.design_patterns.abstract_factory.pizza_factory.Clams {
        return playground.design_patterns.abstract_factory.pizza_factory.FreshClams()
    }
}
/*==============================*/
class ChicagoPizzaIngredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory {
    override fun createDough(): playground.design_patterns.abstract_factory.pizza_factory.Dough {
        return playground.design_patterns.abstract_factory.pizza_factory.ThickCrustDough()
    }

    override fun createSauce(): playground.design_patterns.abstract_factory.pizza_factory.Sauce {
        return playground.design_patterns.abstract_factory.pizza_factory.PlumTomatoSauce()
    }

    override fun createCheese(): playground.design_patterns.abstract_factory.pizza_factory.Cheese {
        return playground.design_patterns.abstract_factory.pizza_factory.MozzarellaCheese()
    }

    override fun createVeggies(): List<playground.design_patterns.abstract_factory.pizza_factory.Veggies> {
        val veggies = listOf<playground.design_patterns.abstract_factory.pizza_factory.Veggies>(
            playground.design_patterns.abstract_factory.pizza_factory.BlackOlives(),
            playground.design_patterns.abstract_factory.pizza_factory.Spinach(),
            playground.design_patterns.abstract_factory.pizza_factory.Eggplant()
        )

        return veggies
    }

    override fun createPepperoni(): playground.design_patterns.abstract_factory.pizza_factory.Pepperoni {
        return playground.design_patterns.abstract_factory.pizza_factory.SlicedPepperoni()
    }

    override fun createClam(): playground.design_patterns.abstract_factory.pizza_factory.Clams {
        return playground.design_patterns.abstract_factory.pizza_factory.FrozenClams()
    }
}