package playground.design_patterns.compound.mvc

import java.io.File
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.Line

interface BeatModelInterface {
    fun initialize()
    fun on()
    fun off()
    var bpm: Int

    fun registerObserver(o: BeatObserver)
    fun removeObserver(o: BeatObserver)
    fun registerObserver(o: BPMObserver)
    fun removeObserver(o: BPMObserver)
}

class BeatModel : BeatModelInterface, Runnable {
    var beatObservers: MutableList<BeatObserver> = mutableListOf<BeatObserver>()
    var bpmObservers: MutableList<BPMObserver> = mutableListOf<BPMObserver>()
//    override var bpm: Int = 90
    var thread: Thread? = null
    var stop: Boolean = false
    var clip: Clip? = null

    override fun initialize() {
        try {
            val resource = File("C:\\Users\\mkaheli\\dev\\learn\\kotlin\\Kotlin_Playground_1\\app\\src\\main\\kotlin\\playground\\design_patterns\\compound\\mvc\\clap.wav")
            clip = AudioSystem.getLine(Line.Info(Clip::class.java)) as Clip
            clip!!.open(AudioSystem.getAudioInputStream(resource))
        } catch (ex: Exception) {
            println("Error: Can’t load clip");
            println(ex)
        }
    }

    override fun on() {
        bpm = 90
        notifyBPMObservers()
        thread = Thread(this)
        stop = false
        thread!!.start()
    }

    override fun off() {
        stopBeat()
        stop = true
    }

    override fun run() {
        while (!stop) {
            playBeat()
            notifyBeatObservers()
            try {
                Thread.sleep((60000 / bpm).toLong())
            } catch (e: Exception) {
            }
        }
    }

    override var bpm: Int = 90
        set(bpm) {
            field = bpm
            notifyBPMObservers()
        }

    // Code to register and notify observers
    override fun registerObserver(o: BeatObserver) {
        beatObservers.add(o)
    }

    fun notifyBeatObservers() {
        for (i in beatObservers.indices) {
            beatObservers[i].updateBeat()
        }
    }

    override fun registerObserver(o: BPMObserver) {
        bpmObservers.add(o)
    }

    fun notifyBPMObservers() {
        for (i in bpmObservers.indices) {
            bpmObservers[i].updateBPM()
        }
    }

    override fun removeObserver(o: BeatObserver) {
        val i = beatObservers.indexOf(o)
        if (i >= 0) {
            beatObservers.removeAt(i)
        }
    }

    override fun removeObserver(o: BPMObserver) {
        val i = bpmObservers.indexOf(o)
        if (i >= 0) {
            bpmObservers.removeAt(i)
        }
    }

    // Audio code to handle the beat

    fun playBeat() {
        clip!!.framePosition = 0
        clip!!.start()
    }

    fun stopBeat() {
        clip!!.framePosition = 0
        clip!!.stop()
    }
}