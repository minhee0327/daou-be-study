package chapter08

fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == OS.WINDOWS }.map { it.duration }.average()

fun main(){
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))
}