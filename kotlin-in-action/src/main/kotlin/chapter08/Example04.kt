package chapter08

import java.lang.StringBuilder

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }, //함수타입 파라미터 선언과 동시에 람다를 디폴트 값으로 지정
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

fun main(){
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString{ it.toLowerCase() })
    println(letters.joinToString(separator = "! ", postfix = "! ", transform = {it.toUpperCase()}))

}
