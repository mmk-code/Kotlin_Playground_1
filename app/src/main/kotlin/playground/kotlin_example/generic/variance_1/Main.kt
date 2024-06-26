package playground.kotlin_example.generic.variance_1


// Declaration-site variance examples
open class VendingMachine1<out T: Snack>(private val snack: T) {
    open fun purchase(money: Coin): T = snack
    // fun refund(snack: T): Coin = Dime() // this line of code generate error since T should not appear
// as function parameter for other function
}

open class VendingMachine2 <in T: Money> {
    open fun purchase(money: T): Snack = Snack()
//    fun refund(snack: Snack): T = Coin() // this line of code generate error since T should not appear
// as function return for other function
}

// Use-site variance

class VendingMachine<T : Product>(private val product: T) {
    fun purchase(money: Money): T = product
    fun refund(product: T): Money = Dime()
}
fun getSnackFrom(machine: VendingMachine<Snack>): Snack {
    return machine.purchase(Dime())
}

fun getRefundFrom(machine: VendingMachine<CandyBar>): Money {
    return machine.refund(CandyBar())
}


fun main() {

    val candyBarMachine: VendingMachine1<CandyBar> = VendingMachine1(CandyBar())
    val vendingMachine: VendingMachine1<Snack> = candyBarMachine // This generate error if remove the out specifier

    val moneyVendingMachine: VendingMachine2<Money> = VendingMachine2()
    val coinVendingMachine: VendingMachine2<Coin> = moneyVendingMachine // This generate error if remove the in specifier
}