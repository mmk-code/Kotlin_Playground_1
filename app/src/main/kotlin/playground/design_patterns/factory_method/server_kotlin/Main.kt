package playground.design_patterns.factory_method.server_kotlin

class Server private constructor(port: Long) {

    init {
        println("Server started on port $port")
    }
    companion object {
        // Factory method design pattern
        fun withPort(port: Long) = Server(port)
    }
}


fun main() {
    val server = Server.withPort(8088)
}