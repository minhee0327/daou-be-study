package chapter02

class Person(
    val name: String,       // 읽기 전용 프로퍼티, 코틀린은 (비공개) 필드와 필드를 읽는 단순한 (공개) 게터를 만들어낸다.
    var isMarried: Boolean  // 쓸 수 있는 프로퍼티로, 코틀린은 (비공개) 필드, (공개) 게터, (공개) 세터를 만들어낸다
)

fun main(){
    //new 키워드를 사용하지 않고 생성자를 호출
    val person = Person("Bob", true)

    // 프로퍼티 이름을 직접 사용하더라도 코틀린이 자동으로 게터를 호출해준다.
    println(person.name)
    println(person.isMarried)
}