package playground.design_patterns.state.gumball_machine

class GumballMachine(count: Int) {
    companion object {
        const val SOLD_OUT: Int = 0
        const val NO_QUARTER: Int = 1
        const val HAS_QUARTER: Int = 2
        const val SOLD: Int = 3
    }

    private var state: Int = SOLD_OUT
    private var count: Int = 0

    init {
        this.count = count
        if (count > 0) {
            state = NO_QUARTER
        }
    }

    fun insertQuarter() {
        when (state) {
            HAS_QUARTER -> {
                println("You can't insert another quarter")
            }
            NO_QUARTER -> {
                state = HAS_QUARTER
                println("You inserted a quarter")
            }
            SOLD_OUT -> {
                println("You can't insert a quarter, the machine is sold out")
            }
            SOLD -> {
                println("Please wait, we're already giving you a gumball")
            }
        }
    }

    fun ejectQuarter() {
        when (state) {
            HAS_QUARTER -> {
                println("Quarter returned")
                state = NO_QUARTER
            }
            NO_QUARTER -> {
                println("You haven't inserted a quarter")
            }
            SOLD -> {
                println("Sorry, you already turned the crank")
            }
            SOLD_OUT -> {
                println("You can't eject, you haven't inserted a quarter yet")
            }
        }
    }

    fun turnCrank() {
        when (state) {
            SOLD -> {
                println("Turning twice doesn't get you another gumball!")
            }
            NO_QUARTER -> {
                println("You turned but there's no quarter")
            }
            SOLD_OUT -> {
                println("You turned, but there are no gumballs")
            }
            HAS_QUARTER -> {
                println("You turned...")
                state = SOLD
                dispense()
            }
        }
    }

    fun dispense() {
        when (state) {
            SOLD -> {
                println("A gumball comes rolling out the slot")
                count -= 1
                if (count == 0) {
                    println("Oops, out of gumballs!")
                    state = SOLD_OUT
                } else {
                    state = NO_QUARTER
                }
            }
            NO_QUARTER -> {
                println("You need to pay first")
            }
            SOLD_OUT -> {
                println("No gumball dispensed")
            }
            HAS_QUARTER -> {
                println("You need to turn the crank")
            }
        }
    }

    // other methods here like toString() and refill()

    fun refill(refill: Int) {
        count += refill
        if (state != HAS_QUARTER) {
            state = NO_QUARTER
        }
    }

    override fun toString(): String {
        val stateText: String = when (state) {
            SOLD_OUT -> "Machine is sold out. The machine will be filled soon..."
            NO_QUARTER -> "Machine is waiting for quarter..."
            HAS_QUARTER -> "Please Turn crank or Eject your quarter..."
            SOLD -> "Please collect gumball from slot..."
            else -> "Machine is waiting for quarter..."
        }
        val countText: String = when (count) {
            0 -> "NO GUMBALLS"
            1 -> "$count gumball"
            else -> "$count gumballs"
        }
        return """
            
            Mighty Gumball, Inc.
            Java-enabled Standing Gumball Model #2004
            Inventory: $countText
            $stateText
            
            """.trimIndent()
    }
}
