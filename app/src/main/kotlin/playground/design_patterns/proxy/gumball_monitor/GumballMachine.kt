package playground.design_patterns.proxy.gumball_monitor



class GumballMachine(numberGumballs: Int) {
    var soldOutState: State = SoldOutState(this)
        private set
    var noQuarterState: State = NoQuarterState(this)
        private set
    var hasQuarterState: State = HasQuarterState(this)
        private set
    var soldState: State = SoldState(this)
        private set
    var winnerState: State = WinnerState(this)
        private set

    private lateinit var state: State
    var count: Int = 0
        private set

    init {
        this.count = numberGumballs
        state = if (numberGumballs > 0) {
            noQuarterState
        } else {
            soldOutState
        }
    }

    fun insertQuarter() {
        state.insertQuarter()
    }

    fun ejectQuarter() {
        state.ejectQuarter()
    }

    fun turnCrank() {
        state.turnCrank()
//        println(this) // un-comment for test purpose
        state.dispense()
    }

    fun refill(top: Int) {
        count += top
        println("The gumball machine was just refilled; its new count is: $count")
        state.refill()
    }

    fun setState(state: State) {
        this.state = state
    }

    fun releaseBall() {
        println("A gumball comes rolling out the slot...")
        if (count > 0) {
            count -= 1
        }
    }

    override fun toString(): String {
        val stateText: String = when (state) {
            soldOutState -> "Machine is sold out. The machine will be filled soon..."
            noQuarterState -> "Machine is waiting for quarter..."
            hasQuarterState -> "Please Turn the crank..."
            soldState -> "Please collect gumball from slot..."
            winnerState -> "Please collect gumballs from slot..."
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

