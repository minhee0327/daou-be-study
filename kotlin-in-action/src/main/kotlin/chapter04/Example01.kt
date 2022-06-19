package chapter04

interface Clickable {
    fun click()
    fun showOff() = println("I'm Clickable!")
}

interface Focusable{
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm Focusable!")
}

class Button: Clickable, Focusable{
    override fun click() = println("I was clicked")
    override fun showOff(){
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton: Clickable{ // 이 클래스는 열려있다. 다른 클래스가 이 클래스를 상속할 수 있다.
    fun disable() {} //final (하위에서 이 메서드를 오버라이드 할 수 없다.

    open fun animate() {} // 하위 클래스에서 이 메서드를 오버라이드 해도 된다.

    override fun click() {} //상위 클래스의 열려있는 메서드를 오버라이드한다. (오버라이드한 메서드는 기본적으로 열려있다.

    //final override fun click(){} //이 하위 클래스들에ㅓ는 오버라이드 하지 못하도록 금지
}

fun main(){
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
