package chapter07

import java.time.LocalDate

fun main(){
    val now = LocalDate.now()
    //.. -> now.rangeTo(now.plusDays(10))
    val vacation = now..now.plusDays(10) //now ~ now + 10
    println(now.plusWeeks(1) in vacation)
}