package chapter08

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate)
        .map(SiteVisit::duration)
        .average()

fun main(){
    println(log.averageDurationFor { it.os in setOf(OS.IOS, OS.ANDROID) })
    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })
}