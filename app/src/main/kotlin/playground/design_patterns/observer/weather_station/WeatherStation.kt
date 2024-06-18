package playground.design_patterns.observer.weather_station

data class WeatherData(
    var temperature: Float,
    var humidity: Float,
    var pressure: Float,
    var windSpeed: Float
)

class WeatherStation: Subject {
    private val observers = mutableListOf<Observer>()
    private lateinit var weatherData: WeatherData

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach { it.update()}
    }

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float, windSpeed: Float=0f) {
        weatherData = WeatherData(temperature, humidity, pressure, windSpeed)

        measurementsChanged()
    }

    fun getTemperature() = weatherData.temperature
    fun getHumidity() = weatherData.humidity
    fun getPressure() = weatherData.pressure
}