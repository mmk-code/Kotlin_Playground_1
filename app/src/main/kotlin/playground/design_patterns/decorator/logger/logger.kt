package playground.design_patterns.decorator.logger

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun interface Logger {
    fun log(message: String)
}

class ConsoleLogger: Logger {
    override fun log(message: String) {
        println(message)
    }
}

class UniqueIdLogger(private val logger: Logger): Logger {
    override fun log(message: String) = logger.log("${UUID.randomUUID()} $message")
}

class ThreadNameLogger(private val logger: Logger): Logger {
    override fun log(message: String) = logger.log("$message (on ${Thread.currentThread().name} thread)")
}

class TimestampLogger(private val logger: Logger): Logger {
    override fun log(message: String) = logger.log("[${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}] $message")
}

/*
========================================
    Using SAM and Functions Extension
========================================
*/
val consoleLogger = Logger { println(it) }

fun Logger.withUniqueId() = Logger { log("${UUID.randomUUID()} $it") }
fun Logger.withThreadName() = Logger { log("$it (on ${Thread.currentThread().name} thread)") }
fun Logger.withTimestamp() = Logger {
    val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    log("[$timestamp] $it")
}

/*
============================================
    Using Typealias and Function Extension
============================================
*/
typealias Logger2 = (s : String) -> Unit

val consoleLogger2: Logger2 = ::println

fun Logger2.withUniqueId2(): Logger2 = {
    this("${UUID.randomUUID()} $it")
}

fun Logger2.withThreadName2(): Logger2 =  {
    this("$it (on ${Thread.currentThread().name} thread)")
}

fun Logger2.withTimestamp2(): Logger2 = {
    val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    this("[$timestamp] $it")
}


fun main() {

    val logger1 = UniqueIdLogger(ThreadNameLogger(TimestampLogger(ConsoleLogger())))
    logger1.log("Application Initialized 1")

    Thread.sleep(1000)
    val logger2 = consoleLogger.withTimestamp().withThreadName().withUniqueId()

    logger2.log("Application Initialized 2")

    Thread.sleep(1000)
    val logger3 = consoleLogger2.withTimestamp2().withThreadName2().withUniqueId2()
    logger3("Application Initialized 3")

    Thread.sleep(2000)
    consoleLogger2.withTimestamp2().withThreadName2().withUniqueId2()("Application Initialized 4")
}