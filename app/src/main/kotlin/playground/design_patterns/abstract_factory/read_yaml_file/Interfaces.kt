package playground.design_patterns.abstract_factory.read_yaml_file

interface Property {
    val name: String
    val value: Any
}
interface ServerConfiguration {
    val properties: List<Property>
}

data class PropertyImpl(
    override val name: String,
    override val value: Any
) : Property

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration

fun property(prop: String): Property {
    val (name, value) = prop.split(":")
    return when (name) {
        "port" -> PropertyImpl(name, value.trim().toInt())
        "environment" -> PropertyImpl(name, value.trim())
        else -> throw IllegalArgumentException("Unknown property: $name")
    }
}

fun server(propertyStrings: List<String>): ServerConfiguration {
    val parsedProperties = mutableListOf<Property>()
    for (p in propertyStrings) {
        parsedProperties += property(p)
    }
    return ServerConfigurationImpl(parsedProperties)
}