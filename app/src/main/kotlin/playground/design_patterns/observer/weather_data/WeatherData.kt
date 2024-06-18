package playground.design_patterns.observer.weather_data

data class WeatherData(val x: Float = 0f, val y: Float = 0f, val z: Float = 0f): Subject {
    private val observers = mutableListOf<Observer>()
    private var temperature: Float = x
    private var humidity: Float = y
    private var pressure: Float = z

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature, humidity, pressure)}
    }

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure

        measurementsChanged()
    }
}