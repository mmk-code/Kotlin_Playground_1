package playground.design_patterns.strategy.duck



abstract class Duck {
    abstract var quackBehaviour: QuackBehaviour
    abstract var flyBehaviour: FlyBehaviour

    fun performQuack() {
        quackBehaviour.quack()
    }

    fun performFly() {
        flyBehaviour.fly()
    }

    abstract fun display()

    fun swim() {
        println("All ducks float, even decoys!")
    }
}

class MallardDuck : Duck() {

    override var quackBehaviour: QuackBehaviour = Quack()
    override var flyBehaviour: FlyBehaviour = FlyWithWings()

    override fun display() {
        println("I'm real Mallard duck")
    }
}

class ModelDuck: Duck() {
    override var quackBehaviour: QuackBehaviour = Quack()
    override var flyBehaviour: FlyBehaviour = FlyNoWay()

    override fun display() {
        println("I'm a Model Duck")
    }
}


