package playground.design_patterns.iterator.restaurant_menu_kotlin_iterator

// Old Waitress class
//class Waitress(private var pancakeHouseMenu: Menu,
//               private var dinerMenu: Menu,
//               private var cafeMenu: Menu
//) {
//    fun printMenu() {
//        val pancakeIterator = pancakeHouseMenu.createIterator()
//        val dinerIterator = dinerMenu.createIterator()
//        val cafeIterator = cafeMenu.createIterator()
//
//        println("MENU")
//        println("----")
//        println("BREAKFAST")
//        printMenu(pancakeIterator)
//        println()
//        println("LUNCH")
//        printMenu(dinerIterator)
//        println()
//        println("DINNER")
//        printMenu(cafeIterator)
//    }
//
//    private fun printMenu(iterator: Iterator<MenuItem>) {
//        while (iterator.hasNext()) {
//            val menuItem = iterator.next()
//            print(menuItem.name + ", ")
//            print(menuItem.price.toString() + " -- ")
//            println(menuItem.description)
//        }
//    }
//
//    // other methods here
//}

class Waitress(private var menus: List<Menu>) {
    fun printMenu() {
        println("MENU")
        println("----")

        val menuIterator = menus.iterator()
        while (menuIterator.hasNext()) {
            println()
            val menu = menuIterator.next()
            println(menu.toString())
            printMenu(menu.createIterator())
        }
    }

    private fun printMenu(iterator: Iterator<MenuItem>) {
        while (iterator.hasNext()) {
            val menuItem = iterator.next()
            print(menuItem.name + ", ")
            print(menuItem.price.toString() + " -- ")
            println(menuItem.description)
        }
    }
}