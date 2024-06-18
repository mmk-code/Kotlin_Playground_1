package playground.design_patterns.state.gumball_machine_interface

import kotlin.random.Random

interface State {
    fun insertQuarter()
    fun ejectQuarter()
    fun turnCrank()
    fun dispense()
    fun refill()
}

internal class NoQuarterState(private var gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("You inserted a quarter")
        gumballMachine.setState(gumballMachine.hasQuarterState)
    }

    override fun ejectQuarter() {
        println("You haven't inserted a quarter")
    }

    override fun turnCrank() {
        println("You turned crank, but there's no quarter")
    }

    override fun dispense() {
        println("You need to pay first")
    }

    override fun refill() {}
}

internal class HasQuarterState(private var gumballMachine: GumballMachine) : State {
    // Instantiate the Random number generator with seed
    private var randomWinner: Random = Random(System.currentTimeMillis())
    override fun insertQuarter() {
        println("You can't insert another quarter")
    }

    override fun ejectQuarter() {
        println("Quarter returned back")
        gumballMachine.setState(gumballMachine.noQuarterState)
    }

    override fun turnCrank() {
        println("You turned crank...")
        val winner = randomWinner.nextInt(10)   // Get random number from 0..10 exclusive
        if ((winner == 0) && (gumballMachine.count > 1)) {
            gumballMachine.setState(gumballMachine.winnerState)
        } else {
            gumballMachine.setState(gumballMachine.soldState)
        }
//        println("You turned crank...")
//        gumballMachine.setState(gumballMachine.soldState)
    }

    override fun dispense() {
        println("No gumball dispensed")
    }

    override fun refill() {}
}

internal class SoldState(private var gumballMachine: GumballMachine) : State {
    //constructor and instance variables here
    override fun insertQuarter() {
        println("Please wait, we're already giving you a gumball")
    }

    override fun ejectQuarter() {
        println("Sorry, you already turned the crank")
    }

    override fun turnCrank() {
        println("Turning the crank twice doesn't get you another gumball!")
    }

    override fun dispense() {
        gumballMachine.releaseBall()
        if (gumballMachine.count > 0) {
            gumballMachine.setState(gumballMachine.noQuarterState)
        } else {
            println("Oops, out of gumballs!")
            gumballMachine.setState(gumballMachine.soldOutState)
        }
    }

    override fun refill() {}
}

internal class SoldOutState(private var gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("You can't insert a quarter, the machine is sold out")
    }

    override fun ejectQuarter() {
        println("You can't eject, you haven't inserted a quarter yet")
    }

    override fun turnCrank() {
        println("You turned crank, but there are no gumballs")
    }

    override fun dispense() {
        println("No gumball dispensed")
    }

    override fun refill() {
        gumballMachine.setState(gumballMachine.noQuarterState)
    }
}

internal class WinnerState(private var gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("Please wait, we're already giving you a gumball")
    }

    override fun ejectQuarter() {
        println("Sorry, you already turned the crank")
    }

    override fun turnCrank() {
        println("Turning the crank twice doesn't get you another gumball!")
    }

    override fun dispense() {
        gumballMachine.releaseBall()
        if (gumballMachine.count == 0) {
            gumballMachine.setState(gumballMachine.soldOutState)
        } else {
            gumballMachine.releaseBall()
            println("YOU'RE A WINNER! You got two gumballs for your quarter")
            if (gumballMachine.count > 0) {
                gumballMachine.setState(gumballMachine.noQuarterState)
            } else {
                println("Oops, out of gumballs!")
                gumballMachine.setState(gumballMachine.soldOutState)
            }
        }
    }

    override fun refill() {}
}