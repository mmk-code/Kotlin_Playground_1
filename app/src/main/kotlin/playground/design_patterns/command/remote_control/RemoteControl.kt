package playground.design_patterns.command.remote_control

class RemoteControl {
    private var onCommands: Array<Command?> = arrayOfNulls(7)
    private var offCommands: Array<Command?> = arrayOfNulls(7)
    private var undoCommand: Command? = null
    // still not used buttons on remote control
    private var sideCommands: Array<Command?> = arrayOfNulls(7)

    init {
        for (i in 0..6) {
            onCommands[i] = NoCommand()
            offCommands[i] = NoCommand()
            sideCommands[i] = NoCommand()
        }
        undoCommand = NoCommand()
    }

    fun setCommand(slot: Int, onCommand: Command?, offCommand: Command?) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot]!!.execute()
        undoCommand = onCommands[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot]!!.execute()
        undoCommand = onCommands[slot]
    }

    fun undoButtonWasPushed() {
        undoCommand!!.undo()
    }

    override fun toString(): String {
        val stringBuffer = StringBuffer()
        stringBuffer.append("\n------ Remote Control -------\n")
        for (i in onCommands.indices) {
            stringBuffer.append("[slot $i] ${onCommands[i]!!}\t${offCommands[i]!!}\n")
        }
        stringBuffer.append("[undo] ${undoCommand!!}\n")
        return stringBuffer.toString()
    }
}