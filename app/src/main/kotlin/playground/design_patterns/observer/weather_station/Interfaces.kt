package playground.design_patterns.observer.weather_station

interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update()
}

interface DisplayElement {
    fun display()
}