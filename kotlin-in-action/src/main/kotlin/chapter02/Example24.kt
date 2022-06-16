package chapter02

import java.util.*

fun main(){
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A' .. 'Z'){
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for((letter, binary) in binaryReps){
        println("$letter = $binary")
    }
}