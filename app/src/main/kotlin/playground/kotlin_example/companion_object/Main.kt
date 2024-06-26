package playground.kotlin_example.companion_object

class A(private var aProperty: Int) {
    private fun aFun1(x: Int): Int {
        aProperty = x
        return aProperty + 10
    }

    companion object {
//        fun coFun1(x: Int) = aProperty + x
    }

    class nA {
//        fun nestAFun1(x: Int) = aFun1(x)
    }

    inner class iA {
        fun innerFun1(x: Int) {
            aProperty += 10
            aFun1(x) + 1
        }
    }
}

fun main() {
    
}

