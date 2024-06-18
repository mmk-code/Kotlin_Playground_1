package playground.design_patterns.strategy.duck

fun main() {
    val mallard= MallardDuck()

    mallard.display()
    mallard.performQuack()
    mallard.performFly()

    val model: Duck = ModelDuck()

    model.display()
    model.swim()
    model.performFly()
    model.flyBehaviour = FlyRocketPowered()
    model.performFly()
}