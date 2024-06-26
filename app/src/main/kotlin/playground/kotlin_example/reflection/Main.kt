package playground.kotlin_example.reflection

import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.reflect


class A(val x: Int, val s: String) {
    fun doSomething(): Boolean {
        println("Do something in A class")
        return true
    }
}

data class B(val z: Int, val c: String)


fun main() {
//  1. Class type access using ::class
    val aClassRef = A::class
    val b = B(3, "some text")
    val i = 1::class
    val s = "Hello World"::class

    println("Reflection class $aClassRef")
    println("Reflection class ${b::class}")
    println("Reflection class type $i")
    println("Reflection class type $s")

//  2. Class Members, Properties and functions inspection

    for (member in aClassRef.members) {
        println(member.name)
    }
    for (property in aClassRef.memberProperties) {
        println(property.name)
    }
    for (function in aClassRef.functions) {
        println(function.name)
    }

    println("=======================")
    for (member in s.members) {
        println(member.name)
    }
    println("=======================")
    for (property in s.memberProperties) {
        println(property.name)
    }


//  3. Function Reference using ::
    println("=======================")
    fun isOdd(n: Int) = n%2 != 0
    val iList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(iList.filter(::isOdd))

    println("=======================")
//  Bounded Function Reference using Object Receiver and ::
    val aSomething1 = A::doSomething
//    OR
    val aSomething2: (A) -> Boolean = A::doSomething
//    OR
    val aSomething3: A.() -> Boolean = A::doSomething

    val ax = A(1,"xyz")
    aSomething1(ax)
    aSomething2(ax)
    aSomething3(ax)
    ax.aSomething3()


//  4. Property  Reference using ::


//  5. Constructor Reference using ::
    val bConstructor = ::B

    val bObj = bConstructor(4, "xyz")
    println(bObj)

    val fooObj = ::Foo
    println(function(fooObj))
    

}

class Foo
fun <T> function(f: () -> T): T = f()


