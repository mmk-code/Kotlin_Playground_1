package playground.design_patterns.iterator.restaurant_menu

fun main() {
    val pancakeHouseMenu = PancakeHouseMenu()
    val dinerMenu = DinerMenu()
    val waitress = Waitress(pancakeHouseMenu, dinerMenu)

    waitress.printMenu()
}