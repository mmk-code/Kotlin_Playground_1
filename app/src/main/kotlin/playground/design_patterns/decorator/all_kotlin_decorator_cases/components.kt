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

interface A {
    fun koo()
}

class Aer: A {
    override fun koo() {
        println("Aer function koo called")
    }
}

class DelegatorClassA: A by Aer()
class DecoratorClassA: A by Aer() {
    override fun koo() {
        val aer = Aer()
        aer.koo()
        println("DecoratorClassA koo function called after")
    }
}

class DecoratorClass1A(val a:A): A by a {
    override fun koo() {
        println("DecoratorClass1A koo function called before")
        a.koo()
        println("DecoratorClass1A koo function called after")
    }
}


fun main() {
    val decoratorClass = DecoratorClass(AbCer())
    decoratorClass.foo()
    println("================")

    decoratorClass.bar()
    println("================")

    val delegatorClassA = DelegatorClassA()
    delegatorClassA.koo()

    println("================")
    val decoratorClassA = DecoratorClassA()
    decoratorClassA.koo()

    println("================")
    val decoratorClass1A = DecoratorClass1A(Aer())
    decoratorClass1A.koo()

    println("================")
    val aer1: A = Aer()
//    val aer2: A = aer1.foo { println("Decorated by Extension foo called") }
//    aer2.koo()
    aer1.foo { println("Decorated by Extension foo called") }.koo()
}

// Extension function as decorator
fun A.foo(block: () -> Unit): A {
    return object : A {
        override fun koo() {
            block()
            this@foo.koo()
        }
    }
}
