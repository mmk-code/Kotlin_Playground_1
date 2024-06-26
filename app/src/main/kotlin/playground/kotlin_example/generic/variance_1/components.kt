package playground.kotlin_example.generic.variance_1

open class Product
open class Snack: Product()
class TrailMix: Snack()
class GummyBears: Snack()
class CandyBar: Snack()

open class Toy: Product()
class ActionFigure: Toy()
class BouncyBall: Toy()
class Sticker: Toy()

//=========================================

open class Money
open class Coin: Money()
class Quarter: Coin()
class Dime: Coin()
class Nickel: Coin()

open class Bill: Money()
class TenDollar: Bill()
class FiveDollar: Bill()
class OneDollar: Bill()













