package playground.design_patterns.abstract_factory.pizza_factory
interface Common {
    val name: String
}

interface Dough: playground.design_patterns.abstract_factory.pizza_factory.Common
interface Sauce: playground.design_patterns.abstract_factory.pizza_factory.Common
interface Veggies: playground.design_patterns.abstract_factory.pizza_factory.Common
interface Cheese: playground.design_patterns.abstract_factory.pizza_factory.Common
interface Pepperoni: playground.design_patterns.abstract_factory.pizza_factory.Common
interface Clams: playground.design_patterns.abstract_factory.pizza_factory.Common

/*==============================*/
data class ThinCrustDough(override val name: String = "Thin Crust Dough"):
    playground.design_patterns.abstract_factory.pizza_factory.Dough {
    override fun toString(): String = name
}
data class ThickCrustDough(override val name: String = "Thick Crust Dough"):
    playground.design_patterns.abstract_factory.pizza_factory.Dough {
    override fun toString(): String = name
}
/*==============================*/
data class Garlic(override val name: String = "Garlic"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class Onion(override val name: String = "Onion"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class Mushroom(override val name: String = "Mushroom"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class RedPepper(override val name: String = "Red Pepper"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class BlackOlives(override val name: String = "Black Olives"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class Spinach(override val name: String = "Spinach"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
data class Eggplant(override val name: String = "Eggplant"):
    playground.design_patterns.abstract_factory.pizza_factory.Veggies {
    override fun toString(): String = name
}
/*==============================*/
data class MarinaraSauce(override val name: String = "Marinara Sauce"):
    playground.design_patterns.abstract_factory.pizza_factory.Sauce {
    override fun toString(): String = name
}
data class PlumTomatoSauce(override val name: String = "Plum Tomato Sauce"):
    playground.design_patterns.abstract_factory.pizza_factory.Sauce {
    override fun toString(): String = name
}
/*==============================*/
data class ReggianoCheese(override val name: String = "Reggiano Cheese"):
    playground.design_patterns.abstract_factory.pizza_factory.Cheese {
    override fun toString(): String = name
}
data class MozzarellaCheese(override val name: String = "Mozzarella Cheese"):
    playground.design_patterns.abstract_factory.pizza_factory.Cheese {
    override fun toString(): String = name
}
/*==============================*/
data class SlicedPepperoni(override val name: String = "Sliced Pepperoni"):
    playground.design_patterns.abstract_factory.pizza_factory.Pepperoni {
    override fun toString(): String = name
}
/*==============================*/
data class FreshClams(override val name: String = "Fresh Clams"):
    playground.design_patterns.abstract_factory.pizza_factory.Clams {
    override fun toString(): String = name
}
data class FrozenClams(override val name: String = "Frozen Clams"):
    playground.design_patterns.abstract_factory.pizza_factory.Clams {
    override fun toString(): String = name
}



