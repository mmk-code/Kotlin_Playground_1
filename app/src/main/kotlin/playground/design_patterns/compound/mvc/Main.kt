package playground.design_patterns.compound.mvc


fun main() {
    val model: BeatModelInterface = BeatModel()
    val controller: ControllerInterface = BeatController(model)
}
