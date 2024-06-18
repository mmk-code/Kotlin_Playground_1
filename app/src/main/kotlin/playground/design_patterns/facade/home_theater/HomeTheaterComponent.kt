package playground.design_patterns.facade.home_theater

class Amplifier {
    fun on() {
        println("Amplifier on")
    }
    fun off() {
        println("Amplifier off")
    }
    fun setStreamingPlayer(player: StreamingPlayer) {
//        player.on()
        println("Amplifier setting Streaming player to Streaming Player")
    }
    fun setSurroundSound() {
        println("Amplifier surround sound on (5 speakers, 1 subwoofer)")
    }
    fun setVolume(volume: Int) {
        println("Amplifier setting volume to $volume")
    }
}
class Tuner {
    fun on() {
        println("Tuner on")
    }

    fun off() {
        println("Tuner off")
    }
}
class StreamingPlayer(private var movie: String = "") {
    fun on() {
        println("Streaming Player on")
    }
    fun off() {
        println("Streaming Player off")
    }
    fun play(movie: String) {
        this.movie = movie
        println("Streaming Player playing \"$movie\"")
    }

    fun stop() {
        println("Streaming Player stopped \"${this.movie}\"")
    }

}
class Projector {

    fun on() {
        println("Projector on")
    }
    fun off() {
        println("Projector off")
    }
    fun wideScreenMode() {
        println("Projector in widescreen mode (16x9 aspect ratio)")
    }
}
class TheaterLights {
    fun dim(dim: Int) {
        println("Theater Ceiling Lights dimming to $dim%")
    }
        fun on() {
            println("Theater Ceiling Lights on")
        }
}
class Screen {
    fun down() {
        println("Theater Screen going down")
    }
    fun up() {
        println("Theater Screen going up")
    }
}
class PopcornPopper {
    fun on() {
        println("Popcorn Popper on")
    }
    fun off() {
        println("Popcorn Popper off")
    }
    fun pop() {
        println("Popcorn Popper popping popcorn!")
    }
}