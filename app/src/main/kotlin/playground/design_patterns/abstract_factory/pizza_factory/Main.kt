package playground.design_patterns.abstract_factory.pizza_factory


fun main() {
    val nyStore: PizzaStore =
        NYPizzaStore()
    val chicagoStore: PizzaStore =
        ChicagoPizzaStore()

    var pizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a " + pizza.name + "\n")

    pizza = chicagoStore.orderPizza("veggie")
    println("Joel ordered a " + pizza.name + "\n")
}