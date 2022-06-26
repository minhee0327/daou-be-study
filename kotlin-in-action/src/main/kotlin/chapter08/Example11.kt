package chapter08

val averageMobileDuration = log
    .filter{it.os in setOf(OS.IOS, OS.ANDROID)}
    .map{it.duration}
    .average()

fun main(){
    println(averageMobileDuration)
}