package playground.design_patterns.iterator.restaurant_menu_kotlin_iterator


class CafeMenu: Menu {
    var menuItems: MutableMap<String, MenuItem> = mutableMapOf()

    init {
        addItem(
            "Soup of the day",
            "A cup of the soup of the day, with a side salad",
            false,
            3.69
        )
        addItem(
            "Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true,
            4.29
        )
        addItem(
            "Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true,
            3.99
        )
    }

    fun addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double,
    ) {
        val menuItem = MenuItem(name, description, isVegetarian, price)

        menuItems[name] = menuItem
    }

//    fun getMenuItems(): Map<String, MenuItem> {
//        return menuItems
//    }

    override fun createIterator(): Iterator<MenuItem> {
        return menuItems.values.iterator()
    }

    override fun toString() = "DINNER"
}