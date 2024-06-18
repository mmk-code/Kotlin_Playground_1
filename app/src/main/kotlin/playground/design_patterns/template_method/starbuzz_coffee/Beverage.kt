package playground.design_patterns.template_method.starbuzz_coffee

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.Locale


//class Tea : CaffeineBeverage() { // in case of abstract class use this class declaration
class Tea : CaffeineBeverage {
    override fun brew() {
        println("Steeping the tea")
    }

    override fun addCondiments() {
        println("Adding Lemon")
    }
}

//class Coffee : CaffeineBeverage() { // in case of abstract class use this class declaration
class Coffee: CaffeineBeverage {
    override fun brew() {
        println("Dripping Coffee through filter")
    }

    override fun addCondiments() {
        println("Adding Sugar and Milk")
    }
}

class CoffeeWithHook : CaffeineBeverageWithHook {
    override val beverageType: String = "Coffee"
    override fun brew() {
        println("Dripping Coffee through filter")
    }

    override fun addCondiments() {
        println("Adding Sugar and Milk")
    }

    override fun customerWantsCondiments(): Boolean {
        val answer = userInput
        return answer.lowercase(Locale.getDefault()).startsWith("y")
    }

    private val userInput: String
        get() {
            var answer: String? = null
            print("Would you like milk and sugar with your coffee (y/n)? ")
//            val `in` = BufferedReader(InputStreamReader(System.`in`))
            try {
//                answer = `in`.readLine()
                answer = readln()
            } catch (ioe: IOException) {
//                System.err.println("IO error trying to read your answer")
                println("IO error trying to read your answer")
            }
            if (answer == null) {
                return "no"
            }
            return answer
        }
}

class TeaWithHook : CaffeineBeverageWithHook {
    override val beverageType: String = "Tea"
    override fun brew() {
        println("Steeping the tea")
    }

    override fun addCondiments() {
        println("Adding Lemon")
    }

    override fun customerWantsCondiments(): Boolean {
        val answer = userInput
        return answer.lowercase(Locale.getDefault()).startsWith("y")
    }

    private val userInput: String
        get() {
            var answer: String? = null
            print("Would you like lemon with your tea (y/n)? ")
//            val `in` = BufferedReader(InputStreamReader(System.`in`))
            try {
//                answer = `in`.readLine()
                answer = readln()
            } catch (ioe: IOException) {
//                System.err.println("IO error trying to read your answer")
                println("IO error trying to read your answer")
            }
            if (answer == null) {
                return "no"
            }
            return answer
        }
}

