package chapter02

import java.io.BufferedReader
import java.io.StringReader

fun readLine(reader: BufferedReader): Int? {
    try{
        val line = reader.readLine()
        return Integer.parseInt(line)
    }catch (e: NumberFormatException){
        return null
    }finally {
        reader.close()
    }
}

fun main(){
    val read = BufferedReader(StringReader("239"))
    println(readLine(read))
}