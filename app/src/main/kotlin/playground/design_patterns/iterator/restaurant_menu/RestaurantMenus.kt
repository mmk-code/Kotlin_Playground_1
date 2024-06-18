package playground.design_patterns.iterator.restaurant_menu


class MenuItem(
    var name: String,
    var description: String,
    var isVegetarian: Boolean,
    var price: Double,
)

class PancakeHouseMenu {
    var menuItems: MutableList<MenuItem> = mutableListOf()

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
        name: String?,
        description: String?,
        vegetarian: Boolean,
        price: Double,
    ) {
        val menuItem = MenuItem(name!!, description!!, vegetarian, price)
        menuItems.add(menuItem)
    }

//    fun getMenuItems(): MutableList<MenuItem> {
//        return menuItems
//    }

    fun createIterator(): Iterator {
        return PancakeHouseIterator(menuItems)
    }
    // other menu methods here
}

class DinerMenu {
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
            "Hotdog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false,
            3.05
        )
        // a couple of other Diner Menu items added here
    }

    fun addItem(
        name: String?,
        description: String?,
        vegetarian: Boolean,
        price: Double,
    ) {
        val menuItem = MenuItem(name!!, description!!, vegetarian, price)
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full! Can't add item to menu")
        } else {
            menuItems[numberOfItems] = menuItem
            numberOfItems += 1
        }
    }

    fun createIterator(): Iterator {
        return DinerMenuIterator(menuItems)
    }
}