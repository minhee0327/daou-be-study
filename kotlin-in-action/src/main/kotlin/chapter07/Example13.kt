package chapter07

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> { //LocalDate 원소에 대한 Iterator를 구현
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive //compareTo 관례를 사용해 날짜 비교

        override fun next(): LocalDate = current.apply {
            current = plusDays(1)
        }
    }

fun main() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}