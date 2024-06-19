package playground

class App public constructor() {
    // if the header constructor is public then public constructor can be dropped. class App
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun displayAnotherGreeting() { println("Another $greeting")}
}

fun main() {
    println(App().greeting)         // This is allowed since App() is calling the default constructor
    println(App().displayAnotherGreeting())
}