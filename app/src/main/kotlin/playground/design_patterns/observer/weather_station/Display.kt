package playground.design_patterns.observer.weather_station

import kotlin.properties.Delegates


class CurrentConditionsDisplay(private val weatherStation: WeatherStation) : Observer, DisplayElement {
    private var temperature by Delegates.notNull<Float>()
    private var humidity by Delegates.notNull<Float>()
    private var pressure: Float by Delegates.notNull()

    init {
        weatherStation.registerObserver(this)
    }

    override fun update() {
        temperature = weatherStation.getTemperature()
        humidity = weatherStation.getHumidity()
        pressure = weatherStation.getPressure()

        display()
    }

    override fun display() {
        println("Current conditions: $temperature F degrees, humidity $humidity and Pressure $pressure")
    }
}

class StatisticsDisplay(private val weatherStation: WeatherStation) : Observer, DisplayElement {
    private var temperatureList = mutableListOf<Float>()

    init {
        weatherStation.registerObserver(this)
    }

    override fun update() {
        temperatureList.add(weatherStation.getTemperature())

        display()
    }

    override fun display() {
        val avg = temperatureList.sum() / temperatureList.size
        val max = temperatureList.max()
        val min = temperatureList.min()

        println("Avg/Max/Min temperature = $avg/$max/$min")
    }
}
