package playground.design_patterns.factory_method.pizza_factory


abstract class Pizza {
    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    protected var toppings = mutableListOf<String>()
    fun prepare() {
        println("Preparing $name")
        println("Tossing dough...$dough")
        println("Adding sauce...$sauce")
        println("Adding toppings: ")
        for (topping in toppings) {
            println(" $topping")
        }
    }

    fun bake() {
        println("Bake for 25 minutes at 350")
    }

    open fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    fun box() {
        println("Place pizza in official PizzaStore box")
    }
}

class NYStyleCheesePizza : Pizza() {
    init {
        name = "NY Style Sauce and Cheese Pizza"
        dough = "Thin Crust Dough"
        sauce = "Marinara Sauce"
        toppings.add("Grated Reggiano Cheese")
    }
}

class ChicagoStyleCheesePizza : Pizza() {
    init {
        name = "Chicago Style Deep Dish Cheese Pizza"
        dough = "Extra Thick Crust Dough"
        sauce = "Plum Tomato Sauce"
        toppings.add("Shredded Mozzarella Cheese")
    }

    override fun cut() {
        println("Cutting the pizza into square slices")
    }
}