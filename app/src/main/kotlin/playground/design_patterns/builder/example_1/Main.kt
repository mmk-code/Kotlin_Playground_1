package playground.design_patterns.builder.example_1

// Product class
data class Computer(
    val cpu: String,
    val ram: String,
    val storage: String,
    val graphicsCard: String
)

// Builder for Computer
class ComputerBuilder {
    private var cpu: String = "UNKNOWN"
    private var ram: String = "UNKNOWN"
    private var storage: String = "UNKNOWN"
    private var graphicsCard: String = "UNKNOWN"

    fun setCpu(cpu: String) = apply { this.cpu = cpu }
    fun setRam(ram: String) = apply { this.ram = ram }
    fun setStorage(storage: String) = apply { this.storage = storage }
    fun setGraphicsCard(graphicsCard: String) = apply { this.graphicsCard = graphicsCard }

    fun build() = Computer(cpu, ram, storage, graphicsCard)


}

fun main() {
    // Usage
    val myComputer = ComputerBuilder()
        .setCpu("Intel Core i7")
        .setRam("16GB")
        .setStorage("512GB SSD")
        .setGraphicsCard("NVIDIA GeForce RTX 3070")
        .build()

    println("My computer specs: $myComputer")

    // Usage:
    val foodOrder = FoodOrder.Builder()
        .bread("whole wheat")
        .meat("chicken")
        .build()

    println(foodOrder)
}

class FoodOrder private constructor(
    private val bread: String? = "Flat bread",
    private val condiments: String?,
    private val meat: String?,
    private val fish: String?
) {
    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null
    ) {
        private fun validate(): Boolean {
            // Implement custom validation rules
            return true // Return true if valid, false otherwise
        }
        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build(): FoodOrder {
            require(validate()) {
                "Invalid food order"
            }
            return FoodOrder(bread, condiments, meat, fish)
        }
    }

    override fun toString(): String {
        return "$bread, $condiments, $meat and $fish"
    }
}


