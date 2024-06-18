package playground.design_patterns.command.remote_control

object RemoteLoader {
    fun load() {
        val remoteControl = RemoteControl()

        val livingRoomLight = Light("Living Room")
        val kitchenLight = Light("Kitchen")
        val ceilingFan = CeilingFan("Living Room")
        val garageDoor = GarageDoor("Garage Door")
        val stereo = Stereo("Living Room")

        val livingRoomLightOn = LightOnCommand(livingRoomLight)
        val livingRoomLightOff = LightOffCommand(livingRoomLight)
        val kitchenLightOn = LightOnCommand(kitchenLight)
        val kitchenLightOff = LightOffCommand(kitchenLight)
        val ceilingFanOn = CeilingFanOnCommand(ceilingFan)
        val ceilingFanOff = CeilingFanOffCommand(ceilingFan)
        val garageDoorUp = GarageDoorUpCommand(garageDoor)
        val garageDoorDown = GarageDoorDownCommand(garageDoor)
        val stereoOnWithCD = StereoOnWithCDCommand(stereo)
        val stereoOff = StereoOffCommand(stereo)

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff)
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff)
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff)
        remoteControl.setCommand(6, garageDoorUp, garageDoorDown)
        println(remoteControl)

        remoteControl.onButtonWasPushed(0)
        remoteControl.offButtonWasPushed(0)
        remoteControl.onButtonWasPushed(1)
        remoteControl.offButtonWasPushed(1)
        remoteControl.onButtonWasPushed(2)
        remoteControl.offButtonWasPushed(2)
        remoteControl.onButtonWasPushed(3)
        remoteControl.offButtonWasPushed(3)
    }

    fun loadParty() {
        val remoteControl = RemoteControl()

        val light = Light("Living Room")
        val tv = TV("Living Room")
        val stereo = Stereo("Living Room")
        val hottub = Hottub()

        val lightOn = LightOnCommand(light)
        val stereoOn = StereoOnCommand(stereo)
        val tvOn = TVOnCommand(tv)
        val hottubOn = HottubOnCommand(hottub)

        val lightOff = LightOffCommand(light)
        val stereoOff = StereoOffCommand(stereo)
        val tvOff = TVOffCommand(tv)
        val hottubOff = HottubOffCommand(hottub)

        val partyOn = arrayOf(lightOn, stereoOn, tvOn, hottubOn)
        val partyOff = arrayOf(lightOff, stereoOff, tvOff, hottubOff)

        val partyOnMacro = MacroCommand(partyOn)
        val partyOffMacro = MacroCommand(partyOff)

        remoteControl.setCommand(5, partyOnMacro, partyOffMacro)

        println(remoteControl)

        println("--- Pushing Macro On---")
        remoteControl.onButtonWasPushed(5)
        println("--- Pushing Macro Off---")
        remoteControl.offButtonWasPushed(5)
    }
}