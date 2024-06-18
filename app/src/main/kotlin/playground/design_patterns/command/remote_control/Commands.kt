package playground.design_patterns.command.remote_control

interface Command {
    fun execute()
    fun undo()
}

class LightOnCommand(var light: Light) : Command {
    override fun execute() {
        light.on()
    }

    override fun undo() {
        light.off()
    }

    override fun toString() = "${javaClass.simpleName}(${light.name})"
}
class LightOffCommand(var light: Light) : Command {
    override fun execute() {
        light.off()
    }

    override fun undo() {
        light.on()
    }
    override fun toString() = "${javaClass.simpleName}(${light.name})"
}

class CeilingFanOnCommand(var ceilingFan: CeilingFan): Command {
    override fun execute() {
        ceilingFan.on()
    }

    override fun undo() {
        ceilingFan.off()
    }
    override fun toString() = "${javaClass.simpleName}(${ceilingFan.name})"
}

class CeilingFanOffCommand(var ceilingFan: CeilingFan): Command {
    override fun execute() {
        ceilingFan.off()
    }

    override fun undo() {
        ceilingFan.on()
    }
    override fun toString() = "${javaClass.simpleName}(${ceilingFan.name})"
}

class StereoOnWithCDCommand(var stereo: Stereo) : Command {
    override fun execute() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(11)
    }

    override fun undo() {
        stereo.off()
    }
    override fun toString() = "${javaClass.simpleName}(${stereo.name})"
}

class StereoOffCommand(var stereo: Stereo) : Command {
    override fun execute() {
        stereo.off()
    }

    override fun undo() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(11)
    }
    override fun toString() = "${javaClass.simpleName}(${stereo.name})"
}

class GarageDoorUpCommand(var garageDoor: GarageDoor): Command {
    override fun execute() {
        garageDoor.up()
    }

    override fun undo() {
        garageDoor.down()
    }
    override fun toString() = "${javaClass.simpleName}(${garageDoor.name})"
}

class GarageDoorDownCommand(var garageDoor: GarageDoor): Command {
    override fun execute() {
        garageDoor.down()
    }

    override fun undo() {
        garageDoor.up()
    }
    override fun toString() = "${javaClass.simpleName}(${garageDoor.name})"
}

class NoCommand: Command {
    override fun execute() {}
    override fun undo() {}
    override fun toString() = this::class.simpleName.toString()
}

class MacroCommand(var commands: Array<Command>) : Command {
    override fun execute() {
        for (i in commands.indices) {
            commands[i].execute()
        }
    }
    override fun undo() {
        for (i in commands.lastIndex downTo 0) {
//        for (i in commands.size - 1 downTo 0) {
            commands[i].undo()
        }
    }

    override fun toString() = "${this::class.simpleName}"
}

class StereoOnCommand(var stereo: Stereo) : Command {
    override fun execute() {
        stereo.on()
    }
    override fun undo() {
        stereo.off()
    }
    override fun toString() = "${javaClass.simpleName}(${stereo.name})"
}


class TVOnCommand(var tv: TV) : Command {
    override fun execute() {
        tv.on()
    }
    override fun undo() {
        tv.off()
    }
    override fun toString() = "${javaClass.simpleName}(${tv.name})"
}

class TVOffCommand(var tv: TV) : Command {
    override fun execute() {
        tv.off()
    }
    override fun undo() {
        tv.on()
    }
    override fun toString() = "${javaClass.simpleName}(${tv.name})"
}

class HottubOnCommand(var hottub: Hottub) : Command {
    override fun execute() {
        hottub.on()
    }
    override fun undo() {
        hottub.off()
    }
    override fun toString(): String = javaClass.simpleName
}

class HottubOffCommand(var hottub: Hottub) : Command {
    override fun execute() {
        hottub.off()
    }
    override fun undo() {
        hottub.on()
    }
    override fun toString(): String = javaClass.simpleName
}

