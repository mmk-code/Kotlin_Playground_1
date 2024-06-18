package playground.design_patterns.abstract_factory.pizza_factory


fun main(args: Array<String>) {
    val nyStore: playground.design_patterns.abstract_factory.pizza_factory.PizzaStore =
        playground.design_patterns.abstract_factory.pizza_factory.NYPizzaStore()
    val chicagoStore: playground.design_patterns.abstract_factory.pizza_factory.PizzaStore =
        playground.design_patterns.abstract_factory.pizza_factory.ChicagoPizzaStore()

    var pizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a " + pizza.name + "\n")

    pizza = chicagoStore.orderPizza("veggie")
    println("Joel ordered a " + pizza.name + "\n")
}