package playground.design_patterns.composite.restaurant_menu_interface


interface MenuComponent {
    open fun add(menuComponent: MenuComponent) {
        throw UnsupportedOperationException()
    }

    open fun addMenuItem(
        name: String,
        description: String,
        isVegetarian: Boolean,
        price: Double
    ) {
        throw UnsupportedOperationException()
    }

    open fun remove(menuComponent: MenuComponent) {
        throw UnsupportedOperationException()
    }

    open fun getChild(index: Int): MenuComponent {
        throw UnsupportedOperationException()
    }

    open val name: String
        get() {
            throw UnsupportedOperationException()
        }
    open val description: String
        get() {
            throw UnsupportedOperationException()
        }
    open val price: Double
        get() {
            throw UnsupportedOperationException()
        }
    open val isVegetarian: Boolean
        get() {
            throw UnsupportedOperationException()
        }

    open fun print() {
        throw UnsupportedOperationException()
    }
}

class MenuItem(
    override var name: String,
    override var description: String,
    override var isVegetarian: Boolean,
    override var price: Double,
) : MenuComponent {
    override fun print() {
        print(" $name")
        if (isVegetarian) {
            print("(v)")
        }
        println(", $price")
        println(" -- $description")
    }
}

class Menu(override var name: String, override var description: String) : MenuComponent {
    private var menuComponents: MutableList<MenuComponent> = mutableListOf()

    override fun add(menuComponent: MenuComponent) {
        menuComponents.add(menuComponent)
    }

    override fun addMenuItem(name: String, description: String, isVegetarian: Boolean, price: Double) {
        val menuItem = MenuItem(name, description, isVegetarian, price)
        menuComponents.add(menuItem)
    }

    override fun remove(menuComponent: MenuComponent) {
        menuComponents.remove(menuComponent)
    }

    override fun getChild(index: Int): MenuComponent {
        return menuComponents[index]
    }

    override fun print() {
        print(
            """
                
                $name
                """.trimIndent()
        )
        println(", $description")
        println("---------------------")

        menuComponents.forEach { it.print() }
    }
}