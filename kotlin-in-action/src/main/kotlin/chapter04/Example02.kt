package chapter04

internal open class TalkativeButton: Focusable{
    private fun yell() = println("Hey!")
    protected fun whisper() = println("let's talk!")
}

/*
fun TalkativeButton.giveSpeech(){// TalkativeButton(internal) < givSpeech(public) , 따라서 작은걸 참조하려다보니 에러
    yell() //yell 은 private이라서 참조 불가능
    whisper() //protected는 같은 하위 클래스에서만 참조가 가능함
}
*/
