package chapter05

fun alphabet(): String{
    val result = StringBuilder()
    for(letter in 'A'..'Z'){
        result.append(letter)
    }
    result.append("\n Not I know the alphabet!")
    return result.toString()
}

fun main(){
    println(alphabet())
}