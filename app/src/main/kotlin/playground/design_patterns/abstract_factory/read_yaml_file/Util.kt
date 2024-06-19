package playground.design_patterns.abstract_factory.read_yaml_file

import java.io.File

//fun readFileAsString(fileName: String): String = File(fileName).readText(Charsets.UTF_8)


fun getFileHandler(fileName: String): File = File(fileName)