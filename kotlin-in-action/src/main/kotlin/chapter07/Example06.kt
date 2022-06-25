package chapter07

import java.math.BigDecimal

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(){
    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
}