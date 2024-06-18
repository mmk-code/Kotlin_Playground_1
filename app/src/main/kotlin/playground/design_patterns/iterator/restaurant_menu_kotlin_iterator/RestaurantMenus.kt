package playground.design_patterns.iterator.restaurant_menu_kotlin_iterator


data class MenuItem(
    var name: String,
    var description: String,
    var isVegetarian: Boolean,
    var price: Double
)

interface Menu {
    fun createIterator(): Iterator<MenuItem>
}

class PancakeHouseMenu: Menu {
    private var menuItems: MutableList<MenuItem> = mutableListOf()

    init {
        addItem(
            "K&B's Pancake Breakfast",
            "Pancakes with scrambled eggs and toast",
            true,
            2.99
        )
        addItem(
            "Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage",
            false,
            2.99
        )
        addItem(
            "Blueberry Pancakes",
            "Pancakes made with fresh blueberries",
            true,
            3.49
        )
        addItem(
            "Waffles",
            "Waffles with your choice of blueberries or strawberries",
            true,
            3.59
        )
    }

    fun addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double,
    ) {
        val menuItem = MenuItem(name, description, isVegetarian, price)

        menuItems.add(menuItem)
    }

    // No need for below function which exposed the internal of class to iterate over its menu items.
//    fun getMenuItems(): MutableList<MenuItem> {
//        return menuItems
//    }

    override fun createIterator(): Iterator<MenuItem> {
        return menuItems.iterator()
    }
    // other menu methods here
    override fun toString() = "BREAKFAST"
}

class DinerMenu: Menu {
    companion object {
        const val MAX_ITEMS: Int = 6
    }

    private var numberOfItems: Int = 0

    // other menu methods here
    var menuItems: Array<MenuItem?> = arrayOfNulls(MAX_ITEMS)

    init {
        addItem(
            "Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat",
            true,
            2.99
        )
        addItem(
            "BLT",
            "Bacon with lettuce & tomato on whole wheat",
            false,
            2.99
        )
        addItem(
            "Soup of the day",
            "Soup of the day, with a side of potato salad",
            false,
            3.29
        )
        addItem(
            "Hot dog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false,
            3.05
        )
        // a couple of other Diner Menu items added here upto MAX_ITEMS
    }

    fun addItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double,
    ) {
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full! Can't add item to menu")
        } else {
            menuItems[numberOfItems] = MenuItem(name, description, isVegetarian, price)
            numberOfItems += 1
        }
    }

//    override fun createIterator(): Iterator<MenuItem> {
//        return DinerMenuIterator(menuItems)
//    }

    override fun createIterator(): Iterator<MenuItem> = object: Iterator<MenuItem> {
        private var position: Int = 0

        override fun hasNext(): Boolean = position < numberOfItems
        override fun next(): MenuItem = menuItems[position++]!!
    }

    override fun toString() = "LUNCH"
}