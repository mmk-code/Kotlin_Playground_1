package playground.design_patterns.abstract_factory.read_yaml_file

interface Property {
    val name: String
    val value: Any
}
interface ServerConfiguration {
    val properties: List<playground.design_patterns.abstract_factory.read_yaml_file.Property>
}

data class PropertyImpl(
    override val name: String,
    override val value: Any
) : playground.design_patterns.abstract_factory.read_yaml_file.Property

data class ServerConfigurationImpl(
    override val properties: List<playground.design_patterns.abstract_factory.read_yaml_file.Property>
) : playground.design_patterns.abstract_factory.read_yaml_file.ServerConfiguration

fun property(prop: String): playground.design_patterns.abstract_factory.read_yaml_file.Property {
    val (name, value) = prop.split(":")
    return when (name) {
        "port" -> playground.design_patterns.abstract_factory.read_yaml_file.PropertyImpl(name, value.trim().toInt())
        "environment" -> playground.design_patterns.abstract_factory.read_yaml_file.PropertyImpl(name, value.trim())
        else -> throw IllegalArgumentException("Unknown property: $name")
    }
}

fun server(propertyStrings: List<String>): playground.design_patterns.abstract_factory.read_yaml_file.ServerConfiguration {
    val parsedProperties = mutableListOf<playground.design_patterns.abstract_factory.read_yaml_file.Property>()
    for (p in propertyStrings) {
        parsedProperties += playground.design_patterns.abstract_factory.read_yaml_file.property(p)
    }
    return playground.design_patterns.abstract_factory.read_yaml_file.ServerConfigurationImpl(parsedProperties)
}