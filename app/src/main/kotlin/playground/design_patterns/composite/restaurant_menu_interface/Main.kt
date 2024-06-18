package playground.design_patterns.composite.restaurant_menu_interface

/*
 Composite Pattern is using kotlin.collections.Iterator<T> interface
 */
fun main() {
    val pancakeHouseMenu: MenuComponent = Menu("PANCAKE HOUSE MENU", "Breakfast")
    val dinerMenu: MenuComponent = Menu("DINER MENU", "Lunch")
    val cafeMenu: MenuComponent = Menu("CAFE MENU", "Dinner")
    val dessertMenu: MenuComponent = Menu("DESSERT MENU", "Dessert of course!")

    val allMenus: MenuComponent = Menu("ALL MENUS", "All menus combined")

    allMenus.apply {
        add(pancakeHouseMenu)
        add(dinerMenu)
        add(cafeMenu)
    }

    //=======================================================
    //              Add Pancake House Menu
    pancakeHouseMenu.apply {
        add(
            MenuItem(
                "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99
            )
        )
        add(
            MenuItem(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99
            )
        )
        add(
            MenuItem(
                "Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49
            )
        )
        add(
            MenuItem(
                "Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59
            )
        )
    }

    //==============================================================\\
    //                   Add Diner menu items here                  \\
    dinerMenu.apply {
        addMenuItem(
            "Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat",
            true,
            2.99
        )
        addMenuItem(
            "BLT",
            "Bacon with lettuce & tomato on whole wheat",
            false,
            2.99
        )
        addMenuItem(
            "Soup of the day",
            "Soup of the day, with a side of potato salad",
            false,
            3.29
        )
        addMenuItem(
            "Hot dog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false,
            3.05
        )
        add(
            MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89
            )
        )
        add(dessertMenu)
    }

    //========================================================
    //             Add dessert Menu
    dessertMenu.apply {
        add(
            MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true,
                1.59
            )
        )
        addMenuItem(
            "Cheesecake",
            "Creamy New York cheesecake, with a chocolate graham crust",
            true,
            1.99
        )
        addMenuItem(
            "Sorbet",
            "A scoop of raspberry and a scoop of lime",
            true,
            1.89
        )
    }

    //==================================================
    //              Add Cafe Menu
    cafeMenu.apply {
        addMenuItem(
            "Soup of the day",
            "A cup of the soup of the day, with a side salad",
            false,
            3.69
        )
        addMenuItem(
            "Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true,
            4.29
        )
        addMenuItem(
            "Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true,
            3.99
        )
    }

    // add more menu items here
    val waitress = Waitress(allMenus)
    waitress.printMenu()
    println("=======================================")

    try {
        allMenus.getChild(1).getChild(6).print()
    }
    catch (exception: IndexOutOfBoundsException) {
        println("Index out range")
    }

    allMenus.getChild(1).getChild(5).print()

}