package playground.design_patterns.iterator.restaurant_menu_kotlin_iterator

/*
 Iterator Pattern is using kotlin.collections.Iterator<T> interface
 */
fun main() {
    val pancakeHouseMenu = PancakeHouseMenu()
    val dinerMenu = DinerMenu()
    val cafeMenu = CafeMenu()

//    val waitress = Waitress(pancakeHouseMenu, dinerMenu, cafeMenu)
    val waitress = Waitress(listOf(pancakeHouseMenu, dinerMenu, cafeMenu))

    waitress.printMenu()
}