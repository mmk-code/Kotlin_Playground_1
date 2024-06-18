package playground.design_patterns.command.remote_control

data class Light(var name:String) {
    fun on()= println("$name: Light is on")
    fun off()= println("$name: Light is off")
}
data class Stereo(var name: String) {
    fun on()= println("$name: Stereo is on")
    fun off()= println("$name: Stereo is off")
    fun setCD()= println("$name: Stereo CD is played")
    fun setVolume(vol:Int)= println("$name: Stereo volume is set to $vol")
}

data class CeilingFan(var name: String) {
    fun on()= println("$name: Ceiling Fan is on")
    fun off()= println("$name: Ceiling Fan is off")
}
data class GarageDoor(var name: String) {
    fun up()= println("$name: Garage door is open")
    fun down()= println("$name: Garage door is close")
}

data class TV(var name: String) {
    fun on()= println("$name: TV is on")
    fun off()= println("$name: TV is off")
}

class Hottub {
    fun on()= println("Hottub is on")
    fun off()= println("Hottub is off")
}

