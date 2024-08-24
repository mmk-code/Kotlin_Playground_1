package playground.fp.list

sealed class LinkedList <out A> {
    companion object {
        fun <A> of(vararg aa: A): LinkedList<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }
    }
}

data object Nil: LinkedList<Nothing>()

data class Cons<out A>(val head: A, val tail: LinkedList<A>): LinkedList<A>()

//fun <A> tail(xs: LinkedList<A>): LinkedList<A> = when (xs) {
//    is Cons -> xs.tail
//    is Nil -> Nil
//}

fun <A> LinkedList<A>.tail(): LinkedList<A> = when (this) {
    is Cons -> this.tail
    is Nil -> Nil
}

fun <A> LinkedList<A>.head(): A = when (this) {
    is Cons -> this.head
    is Nil -> null!!
}

fun main() {
    val ll1: LinkedList<Double> = Nil
    val ll2: LinkedList<Int> = Cons(1, Cons(2, Nil))
    val ll3 = Cons("a", Cons("b", Cons("c", Nil)))

    val ll4 = LinkedList.of(18, 56, 75)

    println(ll1)
    println(ll3)
    println(ll4)

//    println(tail(ll4))
    println(ll2.tail())
    println(ll1.tail())

}

