package playground.design_patterns.iterator.restaurant_menu_kotlin_iterator

class DinerMenuIterator(private var items: Array<MenuItem?>) : Iterator<MenuItem> {
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
