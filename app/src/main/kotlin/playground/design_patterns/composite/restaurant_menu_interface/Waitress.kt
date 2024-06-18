package playground.design_patterns.composite.restaurant_menu_interface


class Waitress(private var allMenus: MenuComponent) {
    fun printMenu() {
        allMenus.print()
    }
}