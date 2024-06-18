package playground.design_patterns.template_method.starbuzz_coffee

//abstract class CaffeineBeverage {

//    fun prepareRecipe() { //    This method is template method
//        boilWater()
//        brew()
//        pourInCup()
//        addCondiments()
//    }
//
//    abstract fun brew()
//    abstract fun addCondiments()
//    fun boilWater() {
//        println("Boiling water")
//    }
//
//    fun pourInCup() {
//        println("Pouring into cup")
//    }
//}

interface CaffeineBeverage {
    fun prepareRecipe() {   //    This method is template method
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    fun brew()
    fun addCondiments()
    fun boilWater() {
        println("Boiling water")
    }
    fun pourInCup() {
        println("Pouring into cup")
    }
}

interface CaffeineBeverageWithHook: CaffeineBeverage {
    val beverageType:String
    override fun prepareRecipe() {   //    This method is template method
        boilWater()
        brew()
        pourInCup()
        if (customerWantsCondiments()) {
            addCondiments()
        }
        else {
            println("Nothing Added to your $beverageType")
        }
    }
    fun customerWantsCondiments(): Boolean {
        return true
    }
}