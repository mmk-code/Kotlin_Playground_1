package playground.design_patterns.state.gumball_machine

fun main() {
    val gumballMachine = GumballMachine(5)

    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.ejectQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    gumballMachine.ejectQuarter()
    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)

    //====================================
    gumballMachine.refill(5)
    println(gumballMachine)
}