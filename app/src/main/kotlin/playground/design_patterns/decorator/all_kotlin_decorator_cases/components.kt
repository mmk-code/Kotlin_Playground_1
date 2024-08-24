package playground.design_patterns.decorator.all_kotlin_decorator_cases

abstract class AbC {
    abstract fun foo()
    abstract fun bar()
}

class AbCer: AbC() {
    override fun foo() {
        println("AbCer foo called")
    }

    override fun bar() {
        println("AbCer bar called")
    }

}

class DecoratorClass(private val abC: AbC): AbC() {
    override fun foo() {
        println("DecoratorClass foo() before called")
        abC.foo()
        println("DecoratorClass foo() after called")
    }

    override fun bar() {
        abC.bar()
        println("DecoratorClass bar() after called")
    }
}

//==============================================
interface A {
    fun koo()
}

class Aer1: A {
    override fun koo() {
        println("Aer1 function koo called")
    }
}

class Aer2: A {
    override fun koo() {
        println("Aer2 function koo called")
    }
}

class DelegatorClassA1: A by Aer1()
class DelegatorClassA2: A by Aer2()
//============== OR ==================
class DelegatorClassA(val a:A): A by a


class DecoratorClassA(val a:A): A {
    override fun koo() {
        println("DecoratorClassA koo function called before")
        a.koo()
        println("DecoratorClassA koo function called after")
    }
}
//========================================
// Extension function as decorator
fun A.foo(block: () -> Unit): A {
    return object : A {
        override fun koo() {
            block()
            this@foo.koo()
        }
    }
}
//===========================================
fun interface B {
    fun boo()
}

val ber = B { println("ber1 is called") }

fun B.foo1() = B {
    println("Call extension function foo1 before this.boo()")
    boo()
    println("Call extension function foo1 after this.boo()")
}

fun B.foo2() = B {
    println("Call extension function foo2 before this.boo()")
    boo()
    println("Call extension function foo2 after this.boo()")
}

fun main() {
    val decoratorClass = DecoratorClass(AbCer())
    decoratorClass.foo()
    println("================")

    decoratorClass.bar()
    println("================")

    val delegatorClassA1 = DelegatorClassA1()
    delegatorClassA1.koo()
    val delegatorClassA2 = DelegatorClassA2()
    delegatorClassA2.koo()
    println("================")

    var delegatorClassA = DelegatorClassA(Aer1())
    delegatorClassA.koo()
    delegatorClassA = DelegatorClassA(Aer2())
    delegatorClassA.koo()


    println("================")
    val decoratorClassA = DecoratorClassA(Aer1())
    decoratorClassA.koo()

    println("================")
    val aer1: A = Aer1()
//    val aer2: A = aer1.foo { println("Decorated by Extension foo called") }
//    aer2.koo()
    aer1.foo { println("Decorated by Extension foo called") }.koo()
    println("================")

    val ber1 = ber.foo1().foo2()

    ber1.boo()
}

