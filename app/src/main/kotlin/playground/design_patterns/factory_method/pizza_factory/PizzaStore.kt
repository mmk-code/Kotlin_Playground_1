package playground.design_patterns.factory_method.pizza_factory

abstract class PizzaStore {
    fun orderPizza(type: String?): Pizza {
        val pizza: Pizza = createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(type: String?): Pizza
}

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String?): Pizza {
        return when (type) {
            "cheese" -> NYStyleCheesePizza()
//            "veggie" -> NYStyleVeggiePizza()
//            "clam" -> NYStyleClamPizza()
//            "pepperoni" -> NYStylePepperoniPizza()
            else -> null!!
        }
    }
}

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: String?): Pizza {
        return when (type) {
            "cheese" -> ChicagoStyleCheesePizza()
//            "veggie" -> ChicagoStyleVeggiePizza()
//            "clam" -> ChicagoStyleClamPizza()
//            "pepperoni" -> ChicagoStylePepperoniPizza()
            else -> null!!
        }
    }
}

