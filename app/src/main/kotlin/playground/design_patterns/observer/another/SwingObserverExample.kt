package playground.design_patterns.observer.another

import javax.swing.*

class SwingObserverExample {
    var frame: JFrame? = null
    fun go() {
        frame = JFrame()
        val button = JButton("Should I do it?")
        button.addActionListener { event -> println("Don't do it, you might regret it!") }
        button.addActionListener { event -> println("Come on, do it!") }
        // Set frame properties here
    }
}

fun main(args: Array<String>) {
    val example = SwingObserverExample()
    example.go()
}