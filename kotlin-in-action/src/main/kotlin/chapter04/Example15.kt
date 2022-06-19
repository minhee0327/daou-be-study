package chapter04

class User1(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value"
                """.trimIndent()
            )
            field = value
        }
}

fun main(){
    val user = User1("Alice")
    user.address = "Elementstrase 47, 80687 Muenchen"
}