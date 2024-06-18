package playground.design_patterns.factory_method.pizza_factory

fun main(args: Array<String>) {
    val nyStore: PizzaStore = NYPizzaStore()
    val chicagoStore: PizzaStore = ChicagoPizzaStore()

    var pizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a " + pizza.name + "\n")

    pizza = chicagoStore.orderPizza("cheese")
    println("Joel ordered a " + pizza.name + "\n")
}