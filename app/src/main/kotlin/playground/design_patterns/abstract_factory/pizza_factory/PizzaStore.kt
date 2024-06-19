package playground.design_patterns.abstract_factory.pizza_factory



abstract class PizzaStore {
    fun orderPizza(item: String?): Pizza {
        val pizza: Pizza = createPizza(item)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(item: String?): Pizza
}

class NYPizzaStore : PizzaStore() {
    override fun createPizza(item: String?): Pizza {
        var pizza: Pizza? = null
        val ingredientFactory: PizzaIngredientFactory =
            NYPizzaIngredientFactory()

        when (item) {
            "cheese" -> {
                pizza = CheesePizza(ingredientFactory)
                pizza.name = "New York Style Cheese Pizza"
            }
            "veggie" -> {
                pizza = VeggiePizza(ingredientFactory)
                pizza.name = "New York Style Veggie Pizza"
            }
            "clam" -> {
                pizza = ClamPizza(ingredientFactory)
                pizza.name = "New York Style Clam Pizza"
            }
            "pepperoni" -> {
                pizza = PepperoniPizza(ingredientFactory)
                pizza.name = "New York Style Pepperoni Pizza"
            }
        }
        return pizza!!
    }
}

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(item: String?): Pizza {
        var pizza: Pizza? = null
        val ingredientFactory: PizzaIngredientFactory =
            ChicagoPizzaIngredientFactory()

        when (item) {
            "cheese" -> {
                pizza = CheesePizza(ingredientFactory)
                pizza.name = "Chicago Style Cheese Pizza"
            }
            "veggie" -> {
                pizza = VeggiePizza(ingredientFactory)
                pizza.name = "Chicago Style Veggie Pizza"
            }
            "clam" -> {
                pizza = ClamPizza(ingredientFactory)
                pizza.name = "Chicago Style Clam Pizza"
            }
            "pepperoni" -> {
                pizza = PepperoniPizza(ingredientFactory)
                pizza.name = "Chicago Style Pepperoni Pizza"
            }
        }
        return pizza!!
    }
}