package chapter04

class LengthCounter{
    //class 밖에서 counter property 를 변경할 수 없다.
    var counter: Int = 0
        private set

    fun addWord(word: String){
        counter += word.length
    }
}

