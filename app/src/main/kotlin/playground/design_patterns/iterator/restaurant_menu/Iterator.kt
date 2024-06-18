package playground.design_patterns.iterator.restaurant_menu

interface Iterator {
    fun hasNext(): Boolean
    fun next(): MenuItem
}

class DinerMenuIterator(var items: Array<MenuItem?>) : Iterator {
    private var position: Int = 0
    override fun next(): MenuItem {
        val menuItem: MenuItem = items[position]!!
        position += 1
        return menuItem
    }

    override fun hasNext(): Boolean {
        return !((position >= items.size) || (items[position] == null))
    }
}

class PancakeHouseIterator(var items: MutableList<MenuItem>): Iterator {
    private var position: Int = 0
    override fun hasNext(): Boolean {
        return position < items.size
    }

    override fun next(): MenuItem {
        val menuItem = items[position]
        position += 1
        return menuItem
    }

}