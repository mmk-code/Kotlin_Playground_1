package playground.design_patterns.compound.mvc

interface ControllerInterface {
    fun start()
    fun stop()
    fun increaseBPM()
    fun decreaseBPM()
    fun setBPM(bpm: Int)
}

class BeatController(var model: BeatModelInterface) : ControllerInterface {
    var view: DJView = DJView(this, model)

    init {
        view.createView()
        view.createControls()
        view.disableStopMenuItem()
        view.enableStartMenuItem()
        model.initialize()
    }

    override fun start() {
        model.on()
        view.disableStartMenuItem()
        view.enableStopMenuItem()
    }

    override fun stop() {
        model.off()
        view.disableStopMenuItem()
        view.enableStartMenuItem()
    }

    override fun increaseBPM() {
        val bpm: Int = model.bpm
        model.bpm = (bpm + 1)
    }

    override fun decreaseBPM() {
        val bpm: Int = model.bpm
        model.bpm = (bpm - 1)
    }

    override fun setBPM(bpm: Int) {
        model.bpm = (bpm)
    }
}