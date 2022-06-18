package chapter03

import java.lang.StringBuilder

// generic: 어떤 타입의 값을 원소로 하는 컬렉션이든 처리 가능
fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String = ", ", prefix: String = "", postfix: String = "") =
    joinToString(separator, prefix, postfix)

fun main() {
    val list = listOf(1, 2, 3)
    println(list.joinToString(";", "(", ")"))
    println(list.joinToString(" "))

    val stringList = listOf("one", "two", "three")
    println(stringList.join(" "))
}