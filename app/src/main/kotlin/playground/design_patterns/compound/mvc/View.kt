package playground.design_patterns.compound.mvc

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import kotlin.system.exitProcess


interface BeatObserver {
    fun updateBeat()
}

interface BPMObserver {
    fun updateBPM()
}

class DJView(
    var controller: ControllerInterface,
    var model: BeatModelInterface
) : ActionListener, BeatObserver, BPMObserver
{
    var viewFrame: JFrame? = null
    var viewPanel: JPanel? = null
    var beatBar: BeatBar? = null
    var bpmOutputLabel: JLabel? = null

    init {
        model.registerObserver(this as BeatObserver)
        model.registerObserver(this as BPMObserver)
    }

    fun createView() {
        // Create all Swing components here
        viewPanel = JPanel(GridLayout(1, 2))
        viewFrame = JFrame("View")
        viewFrame!!.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        viewFrame!!.size = Dimension(100, 80)
        bpmOutputLabel = JLabel("offline", SwingConstants.CENTER)
        beatBar = BeatBar()
        beatBar!!.value = 0
        val bpmPanel = JPanel(GridLayout(2, 1))
        bpmPanel.add(beatBar)
        bpmPanel.add(bpmOutputLabel)
        viewPanel!!.add(bpmPanel)
        viewFrame!!.contentPane.add(viewPanel!!, BorderLayout.CENTER)
        viewFrame!!.pack()
        viewFrame!!.isVisible = true
    }

    override fun updateBPM() {
        val bpm: Int = model.bpm
        if (bpm == 0) {
            bpmOutputLabel!!.text = "offline"
        } else {
            bpmOutputLabel!!.text = "Current BPM: " + model.bpm
        }
    }

    override fun updateBeat() {
        beatBar!!.value = 100
    }

    //==============================================

    var bpmLabel: JLabel? = null
    var bpmTextField: JTextField? = null
    var setBPMButton: JButton? = null
    var increaseBPMButton: JButton? = null
    var decreaseBPMButton: JButton? = null
    var menuBar: JMenuBar? = null
    var menu: JMenu? = null
    var startMenuItem: JMenuItem? = null
    var stopMenuItem: JMenuItem? = null

    fun createControls() {
        // Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true)
        val controlFrame = JFrame("Control")
        controlFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        controlFrame.size = Dimension(100, 80)
        val controlPanel = JPanel(GridLayout(1, 2))
        menuBar = JMenuBar()
        menu = JMenu("DJ Control")
        startMenuItem = JMenuItem("Start")
        menu!!.add(startMenuItem)
        startMenuItem!!.addActionListener { controller.start() }
        stopMenuItem = JMenuItem("Stop")
        menu!!.add(stopMenuItem)
        stopMenuItem!!.addActionListener { controller.stop() }
        val exit = JMenuItem("Quit")
        exit.addActionListener { exitProcess(0) }
        menu!!.add(exit)
        menuBar!!.add(menu)
        controlFrame.jMenuBar = menuBar
        bpmTextField = JTextField(2)
        bpmLabel = JLabel("Enter BPM:", SwingConstants.RIGHT)
        setBPMButton = JButton("Set")
        setBPMButton!!.size = Dimension(10, 40)
        increaseBPMButton = JButton(">>")
        decreaseBPMButton = JButton("<<")
        setBPMButton!!.addActionListener(this)
        increaseBPMButton!!.addActionListener(this)
        decreaseBPMButton!!.addActionListener(this)
        val buttonPanel = JPanel(GridLayout(1, 2))
        buttonPanel.add(decreaseBPMButton)
        buttonPanel.add(increaseBPMButton)
        val enterPanel = JPanel(GridLayout(1, 2))
        enterPanel.add(bpmLabel)
        enterPanel.add(bpmTextField)
        val insideControlPanel = JPanel(GridLayout(3, 1))
        insideControlPanel.add(enterPanel)
        insideControlPanel.add(setBPMButton)
        insideControlPanel.add(buttonPanel)
        controlPanel.add(insideControlPanel)
        bpmLabel!!.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)
        bpmOutputLabel!!.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)
        controlFrame.rootPane.defaultButton = setBPMButton
        controlFrame.contentPane.add(controlPanel, BorderLayout.CENTER)
        controlFrame.pack()
        controlFrame.isVisible = true
    }


    fun enableStopMenuItem() {
        stopMenuItem!!.isEnabled = true
    }

    fun disableStopMenuItem() {
        stopMenuItem!!.isEnabled = false
    }

    fun enableStartMenuItem() {
        startMenuItem!!.isEnabled = true
    }

    fun disableStartMenuItem() {
        startMenuItem!!.isEnabled = false
    }

    override fun actionPerformed(event: ActionEvent) {
        if (event.source === setBPMButton) {
            val bpm = bpmTextField!!.text.toInt()
            controller.setBPM(bpm)
        } else if (event.source === increaseBPMButton) {
            controller.increaseBPM()
        } else if (event.source === decreaseBPMButton) {
            controller.decreaseBPM()
        }
    }
}

class BeatBar : JProgressBar(), Runnable {
    var progressBar: JProgressBar? = null
    var thread: Thread = Thread(this)

    init {
        maximum = 100
        thread.start()
    }

    override fun run() {
        while (true) {
            var value = value
            value = (value * .75).toInt()
            setValue(value)
            repaint()
            try {
                Thread.sleep(50)
            } catch (ex: Exception) {
                println(ex)
            }
        }
    }

    companion object {
        private const val serialVersionUID = 2L
    }
}
