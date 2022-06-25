package chapter07

//단항 연산자 정의하기
operator fun Point.unaryMinus(): Point{ //단항 minus 함수는 파라미터가 없다.
    return Point(-x, -y) //좌표의 각 성분의 음수를 취한 새 점을 반환한다.
}

fun main(){
    val p = Point(10, 20)
    println(-p)
}