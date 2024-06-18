package playground.design_patterns.abstract_factory.pizza_factory



abstract class PizzaStore {
    fun orderPizza(item: String?): playground.design_patterns.abstract_factory.pizza_factory.Pizza {
        val pizza: playground.design_patterns.abstract_factory.pizza_factory.Pizza = createPizza(item)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(item: String?): playground.design_patterns.abstract_factory.pizza_factory.Pizza
}

class NYPizzaStore : playground.design_patterns.abstract_factory.pizza_factory.PizzaStore() {
    override fun createPizza(item: String?): playground.design_patterns.abstract_factory.pizza_factory.Pizza {
        var pizza: playground.design_patterns.abstract_factory.pizza_factory.Pizza? = null
        val ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory =
            playground.design_patterns.abstract_factory.pizza_factory.NYPizzaIngredientFactory()

        when (item) {
            "cheese" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.CheesePizza(ingredientFactory)
                pizza.name = "New York Style Cheese Pizza"
            }
            "veggie" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.VeggiePizza(ingredientFactory)
                pizza.name = "New York Style Veggie Pizza"
            }
            "clam" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.ClamPizza(ingredientFactory)
                pizza.name = "New York Style Clam Pizza"
            }
            "pepperoni" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.PepperoniPizza(ingredientFactory)
                pizza.name = "New York Style Pepperoni Pizza"
            }
        }
        return pizza!!
    }
}

class ChicagoPizzaStore : playground.design_patterns.abstract_factory.pizza_factory.PizzaStore() {
    override fun createPizza(item: String?): playground.design_patterns.abstract_factory.pizza_factory.Pizza {
        var pizza: playground.design_patterns.abstract_factory.pizza_factory.Pizza? = null
        val ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory =
            playground.design_patterns.abstract_factory.pizza_factory.ChicagoPizzaIngredientFactory()

        when (item) {
            "cheese" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.CheesePizza(ingredientFactory)
                pizza.name = "Chicago Style Cheese Pizza"
            }
            "veggie" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.VeggiePizza(ingredientFactory)
                pizza.name = "Chicago Style Veggie Pizza"
            }
            "clam" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.ClamPizza(ingredientFactory)
                pizza.name = "Chicago Style Clam Pizza"
            }
            "pepperoni" -> {
                pizza = playground.design_patterns.abstract_factory.pizza_factory.PepperoniPizza(ingredientFactory)
                pizza.name = "Chicago Style Pepperoni Pizza"
            }
        }
        return pizza!!
    }
}