package playground.design_patterns.mediator.chat

// Colleague (ChatUser) class
class ChatUser(private val mediator: ChatMediator, private val name: String) {
    fun send(msg: String) {
        println("$name: Sending Message = $msg")
        mediator.sendMessage(msg, this)
    }

    fun receive(msg: String) {
        println("$name: Message received: $msg")
    }
}

// Mediator class
class ChatMediator {
    private val users: MutableList<ChatUser> = ArrayList()

    fun sendMessage(msg: String, user: ChatUser) {
        users.filter { it != user }.forEach { it.receive(msg) }
    }

    fun addUser(user: ChatUser): ChatMediator = apply {
        users.add(user)
    }
}

// Example usage
fun main() {
    val mediator = ChatMediator()
    val john = ChatUser(mediator, "John")

    mediator.apply {
        addUser(ChatUser(mediator, "Alice"))
        addUser(ChatUser(mediator, "Micheal"))
        addUser(ChatUser(mediator, "Bob"))
        addUser(john)
    }

    john.send("Hi everyone!")
}
