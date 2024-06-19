package playground.design_patterns.abstract_factory.pizza_factory
interface Common {
    val name: String
}

interface Dough: Common
interface Sauce: Common
interface Veggies: Common
interface Cheese: Common
interface Pepperoni: Common
interface Clams: Common

/*==============================*/
data class ThinCrustDough(override val name: String = "Thin Crust Dough"):
    Dough {
    override fun toString(): String = name
}
data class ThickCrustDough(override val name: String = "Thick Crust Dough"):
    Dough {
    override fun toString(): String = name
}
/*==============================*/
data class Garlic(override val name: String = "Garlic"):
    Veggies {
    override fun toString(): String = name
}
data class Onion(override val name: String = "Onion"):
    Veggies {
    override fun toString(): String = name
}
data class Mushroom(override val name: String = "Mushroom"):
    Veggies {
    override fun toString(): String = name
}
data class RedPepper(override val name: String = "Red Pepper"):
    Veggies {
    override fun toString(): String = name
}
data class BlackOlives(override val name: String = "Black Olives"):
    Veggies {
    override fun toString(): String = name
}
data class Spinach(override val name: String = "Spinach"):
    Veggies {
    override fun toString(): String = name
}
data class Eggplant(override val name: String = "Eggplant"):
    Veggies {
    override fun toString(): String = name
}
/*==============================*/
data class MarinaraSauce(override val name: String = "Marinara Sauce"):
    Sauce {
    override fun toString(): String = name
}
data class PlumTomatoSauce(override val name: String = "Plum Tomato Sauce"):
    Sauce {
    override fun toString(): String = name
}
/*==============================*/
data class ReggianoCheese(override val name: String = "Reggiano Cheese"):
    Cheese {
    override fun toString(): String = name
}
data class MozzarellaCheese(override val name: String = "Mozzarella Cheese"):
    Cheese {
    override fun toString(): String = name
}
/*==============================*/
data class SlicedPepperoni(override val name: String = "Sliced Pepperoni"):
    Pepperoni {
    override fun toString(): String = name
}
/*==============================*/
data class FreshClams(override val name: String = "Fresh Clams"):
    Clams {
    override fun toString(): String = name
}
data class FrozenClams(override val name: String = "Frozen Clams"):
    Clams {
    override fun toString(): String = name
}



