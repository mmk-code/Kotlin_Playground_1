package playground.design_patterns.state.gumball_machine_interface

fun main() {
    val gumballMachine = GumballMachine(5)

    println(gumballMachine)

    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()

    println(gumballMachine)

    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()

    println(gumballMachine)

    gumballMachine.refill(5)

    println("===================Test 1===============")
    gumballMachine.insertQuarter()
    println(gumballMachine)
    gumballMachine.turnCrank()
    println(gumballMachine)

    println("===================Test 2===============")
    println(gumballMachine)
    gumballMachine.turnCrank()
    println(gumballMachine)

//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.ejectQuarter()
//    gumballMachine.turnCrank()
//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    gumballMachine.ejectQuarter()
//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    println(gumballMachine)
//    gumballMachine.insertQuarter()
//    gumballMachine.turnCrank()
//    println(gumballMachine)
//
//    //====================================
//    gumballMachine.refill(5)
//    println(gumballMachine)
}