package playground.design_patterns.abstract_factory.read_yaml_file

fun main() {
    // Usage
    val path = "C:\\Users\\mkaheli\\dev\\learn\\kotlin\\Kotlin_Playground_1\\app\\src\\main\\kotlin\\playground\\design_patterns\\abstract_factory\\read_yaml_file"
    val fileName = "server.yaml"
    val fh = getFileHandler("$path\\$fileName")
    val lines = fh.readLines(Charsets.UTF_8)
    println(lines)


//    val portProperty = property(lines[1].trim())
//    val environmentProperty = property(lines[2].trim())

//    val port: Int? = portProperty.value as? Int

//    println(port)
    val properties = listOf(lines[1].trim(), lines[2].trim())
    println(server(properties))



}