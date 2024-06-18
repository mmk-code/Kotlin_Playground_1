package playground.design_patterns.iterator.restaurant_menu

class Waitress(private var pancakeHouseMenu: PancakeHouseMenu, private var dinerMenu: DinerMenu) {
    fun printMenu() {
        val pancakeIterator = pancakeHouseMenu.createIterator()
        val dinerIterator = dinerMenu.createIterator()
        println("MENU")
        println("----")
        println("BREAKFAST")
        printMenu(pancakeIterator)
        println()
        println("LUNCH")
        printMenu(dinerIterator)
    }

    private fun printMenu(iterator: Iterator) {
        while (iterator.hasNext()) {
            val menuItem = iterator.next()
            print(menuItem.name + ", ")
            print(menuItem.price.toString() + " -- ")
            println(menuItem.description)
        }
    }

    // other methods here
}