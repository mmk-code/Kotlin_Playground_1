package playground.design_patterns.observer.weather_data

//import kotlin.math.max
//import kotlin.math.min


class CurrentConditionsDisplay(private val weatherData: WeatherData) : Observer, DisplayElement {
    private var temperature = 0f
    private var humidity = 0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("Current conditions: $temperature F degrees and humidity $humidity")
    }
}

class StatisticsDisplay(private val weatherData: WeatherData) : Observer, DisplayElement {
    private var temperatureList = mutableListOf<Float>()

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        temperatureList.add(temperature)

        display()
    }

    override fun display() {
//        var avg = 0f
//        var max = temperatureList[0]
//        var min = temperatureList[0]

//        temperatureList.forEach {
//            avg += it
//            max = max(max, it)
//            min = min(min, it)
//        }
//        avg /= temperatureList.size


        val avg = temperatureList.sum() / temperatureList.size
        val max = temperatureList.max()
        val min = temperatureList.min()

        println("Avg/Max/Min temperature = $avg/$max/$min")
    }
}
