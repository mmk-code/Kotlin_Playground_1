package playground.design_patterns.composite.restaurant_menu_kotlin_iterator


class Waitress(private var allMenus: MenuComponent) {
    fun printMenu() {
        allMenus.print()
    }
}