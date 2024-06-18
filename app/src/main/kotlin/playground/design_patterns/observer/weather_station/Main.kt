package playground.design_patterns.observer.weather_station

fun main(args: Array<String>) {
    val weatherStation = WeatherStation()
    val currentDisplay = CurrentConditionsDisplay(weatherStation)
    val statisticsDisplay = StatisticsDisplay(weatherStation)
//    val forecastDisplay = ForecastDisplay(weatherData)

    weatherStation.setMeasurements(80f, 65f, 30.4f)
    weatherStation.setMeasurements(82f, 70f, 29.2f)
    weatherStation.setMeasurements(78f, 90f, 29.2f)
}