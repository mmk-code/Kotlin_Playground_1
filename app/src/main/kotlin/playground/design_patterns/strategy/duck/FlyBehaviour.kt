package playground.design_patterns.strategy.duck

interface FlyBehaviour {
    fun fly()
}

class FlyNoWay: FlyBehaviour {
    override fun fly() {
        println("Fly No Way")
    }

}

class FlyRocketPowered: FlyBehaviour {
    override fun fly() {
        println("Fly like Rocket")
    }
}

class FlyWithWings: FlyBehaviour {
    override fun fly() {
        println("I have wings to fly")
    }
}


