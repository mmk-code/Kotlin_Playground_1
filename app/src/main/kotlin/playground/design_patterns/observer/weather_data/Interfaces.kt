package playground.design_patterns.observer.weather_data

interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}