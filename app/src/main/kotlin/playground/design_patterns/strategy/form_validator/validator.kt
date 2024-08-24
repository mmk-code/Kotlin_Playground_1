package playground.design_patterns.strategy.form_validator

typealias Validator = (String) -> Boolean

val emailValidator: Validator = { it.contains("@") && it.contains(".")}
val passwordValidator: Validator = { it.length > 8 }
val usernameValidator: Validator = { it.isNotEmpty() }

class FormFieldValidator(val name: String, private val value: String, private val validator: Validator) {
    fun isValid() = validator(value)
}

fun Validator.optional(): Validator = { it.isEmpty() || this(it) }

fun main() {
    val emailField = FormFieldValidator("e-mail", "jack@example.com", emailValidator.optional())
    printer(emailField)

    val usernameField = FormFieldValidator("Username", "jack1234", usernameValidator)
    printer(usernameField)

    val passwordField = FormFieldValidator("Password", "test1234", passwordValidator)
    printer(passwordField)
}

fun printer(formFieldValidator: FormFieldValidator) = println("${formFieldValidator.name} validation: ${formFieldValidator.isValid()}")