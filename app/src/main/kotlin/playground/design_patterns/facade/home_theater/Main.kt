package playground.design_patterns.facade.home_theater

fun main() {

    // instantiate components here
    val amp = Amplifier()
    val tuner = Tuner()
    val player = StreamingPlayer()
    val projector = Projector()
    val screen = Screen()
    val lights = TheaterLights()
    val popper = PopcornPopper()

    val homeTheater = HomeTheaterFacade(amp, tuner, player, projector, screen, lights, popper)
    homeTheater.watchMovie("Raiders of the Lost Ark")
    println("<=========================================>")
    homeTheater.endMovie()
}