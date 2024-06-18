package playground.design_patterns.abstract_factory.pizza_factory

abstract class Pizza {
    var name: String = ""
    lateinit var dough: playground.design_patterns.abstract_factory.pizza_factory.Dough
    lateinit var sauce: playground.design_patterns.abstract_factory.pizza_factory.Sauce
    lateinit var veggies: List<playground.design_patterns.abstract_factory.pizza_factory.Veggies>
    lateinit var cheese: playground.design_patterns.abstract_factory.pizza_factory.Cheese
    lateinit var pepperoni: playground.design_patterns.abstract_factory.pizza_factory.Pepperoni
    lateinit var clam: playground.design_patterns.abstract_factory.pizza_factory.Clams
    abstract fun prepare()
    fun bake() {
        println("Bake for 25 minutes at 350")
    }

    fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    fun box() {
        println("Place pizza in official PizzaStore box")
    }

    override fun toString(): String {
        return name
    }
}

class CheesePizza(private var ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory) : playground.design_patterns.abstract_factory.pizza_factory.Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = ingredientFactory.createDough()
        sauce = ingredientFactory.createSauce()
        cheese = ingredientFactory.createCheese()
        println("===>Ingredient: $dough, $sauce, $cheese")
    }
}

class ClamPizza(private var ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory) : playground.design_patterns.abstract_factory.pizza_factory.Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = ingredientFactory.createDough()
        sauce = ingredientFactory.createSauce()
        cheese = ingredientFactory.createCheese()
        clam = ingredientFactory.createClam()
        println("===>Ingredient: $dough, $sauce, $cheese, $clam")
    }
}

class VeggiePizza(private var ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory) : playground.design_patterns.abstract_factory.pizza_factory.Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = ingredientFactory.createDough()
        veggies = ingredientFactory.createVeggies()
        sauce = ingredientFactory.createSauce()
        cheese = ingredientFactory.createCheese()

        println("===>Ingredient: $dough, $sauce, $veggies, $cheese")
    }
}

class PepperoniPizza(private var ingredientFactory: playground.design_patterns.abstract_factory.pizza_factory.PizzaIngredientFactory) : playground.design_patterns.abstract_factory.pizza_factory.Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = ingredientFactory.createDough()
        sauce = ingredientFactory.createSauce()
        pepperoni = ingredientFactory.createPepperoni()
        cheese = ingredientFactory.createCheese()
        println("===>Ingredient: $dough, $sauce, $cheese, $pepperoni")
    }
}