package chapter02.enum

//enum class Color {
//    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
//}

enum class Color(val r: Int, val g: Int, val b: Int) { //상수의 프로퍼티 정의

    RED(255, 0, 0),                  //각 상수를 생성할 때 그에 대한 프로퍼티 값을 지정
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);           //끝은 반드시 세미콜론(;)

    fun rgb() = (r * 256 + g) * 256 + b  //enum class 안에 메서드를 정의한다.
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE -> "Warm"
//        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun main(){
    println(getMnemonic(Color.BLUE))
}