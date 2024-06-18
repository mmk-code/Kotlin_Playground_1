package playground.kotlin_example.swing

import javax.swing.*
import java.awt.FlowLayout

fun main() {
    // Create the JFrame window
    val frame = JFrame("Swing in Kotlin").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = FlowLayout() // Set the layout manager
        setSize(400, 200) // Set the size of the window
    }

    // Create a JLabel
    val label = JLabel("Hello, Swing in Kotlin!").apply {
        toolTipText = "This is a label"
    }

    // Create a JTextField
    val textField = JTextField(20).apply {
        toolTipText = "Enter text here"
    }

    // Create a JButton
    val button = JButton("Click Me!").apply {
        toolTipText = "This is a button"
        addActionListener {
            // Action to perform when the button is clicked
            label.text = "Button clicked! Text: ${textField.text}"
        }
    }

    // Add components to the frame's content pane
    frame.contentPane.add(label)
    frame.contentPane.add(textField)
    frame.contentPane.add(button)

    // Display the window
    frame.isVisible = true
}

