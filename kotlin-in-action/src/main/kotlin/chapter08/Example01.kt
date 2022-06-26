package chapter08

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun main() {
    println(twoAndThree { x, y -> x + y })
    println(twoAndThree { x, y -> x * y })
}