package chapter04

import java.io.Serializable

interface State: Serializable

interface View{
    fun getCurrentState(): State
    fun restoreState(state: State){}
}

class Button2: View{
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {}

    class ButtonState: State {} //자바의 정적 중첩 클래스와 대응
}

class Outer{
    inner class Inner{
        fun getOuterReference(): Outer = this@Outer
    }
}

