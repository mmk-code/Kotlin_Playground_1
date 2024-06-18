package playground.design_patterns.template_method.starbuzz_coffee

fun main() {
    val tea1 = Tea()
    tea1.prepareRecipe()
    println("<==========================================>")
    val coffee1 = Coffee()
    coffee1.prepareRecipe()

    println("<==========================================>")
    val teaHook = TeaWithHook()
    val coffeeHook = CoffeeWithHook()
    println("\nMaking tea...")
    teaHook.prepareRecipe()
    println("\nMaking coffee...")
    coffeeHook.prepareRecipe()

}