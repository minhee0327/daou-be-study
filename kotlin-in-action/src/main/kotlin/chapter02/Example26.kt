package chapter02

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's letter!"
    else -> "I don't know .."
}

fun main(){
    println(recognize('8'))
}