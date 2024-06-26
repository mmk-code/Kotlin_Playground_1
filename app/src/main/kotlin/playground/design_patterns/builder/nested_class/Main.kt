package playground.design_patterns.builder.nested_class

class Car private constructor(
    private val make: String,
    private val model: String,
    private val year: Int,
    private val engine: Engine,
    private val wheels: Wheels,
    private val entertainmentSystem: EntertainmentSystem,
    private val hasSunroof: Boolean = false // New Optional feature with default value
) {
    private data class Engine(val type: String, val horsepower: Int)
    private data class Wheels(val size: Int, val material: String)
    private data class EntertainmentSystem(val hasNavigation: Boolean, val speakers: Int)

    class CarBuilder(private val make: String, private val model: String, private val year: Int) {
        private var engine: Engine? = null
        private var wheels: Wheels? = null
        private var entertainmentSystem: EntertainmentSystem? = null
        private var hasSunroof: Boolean = false // Default value

        fun setEngine(type: String, horsepower: Int): CarBuilder {
            engine = Engine(type, horsepower)
            return this
        }

        fun setWheels(size: Int, material: String): CarBuilder {
            wheels = Wheels(size, material)
            return this
        }

        fun setEntertainmentSystem(hasNavigation: Boolean, speakers: Int): CarBuilder {
            entertainmentSystem = EntertainmentSystem(hasNavigation, speakers)
            return this
        }

        fun setSunroof(hasSunroof: Boolean): CarBuilder {
            this.hasSunroof = hasSunroof
            return this
        }

        fun build(): Car {
            requireNotNull(engine) { "Engine must be set" }
            requireNotNull(wheels) { "Wheels must be set" }
            requireNotNull(entertainmentSystem) { "Entertainment system must be set" }
            return Car(make, model, year, engine!!, wheels!!, entertainmentSystem!!, hasSunroof)
        }
    }

    override fun toString(): String {
        return """
            |Car(Make='$make',
            |Model='$model',
            |Year=$year,
            |Engine = $engine,
            |Wheels = $wheels,
            |Entertainment System = $entertainmentSystem,
            |Sunroof = $hasSunroof)
            """.trimMargin()
    }
}

fun main() {
    val car = Car.CarBuilder("Toyota", "Camry", 2022)
        .setEngine("V6", 300)
        .setWheels(18, "Alloy")
        .setEntertainmentSystem(hasNavigation = true, speakers = 8)
//        .setSunroof(true) // Adding sunroof
        .build()

    println("Constructed car:")
    println(car)
}
