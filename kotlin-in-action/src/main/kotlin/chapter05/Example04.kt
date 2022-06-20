package chapter05

data class Person(var name: String, var age: Int)

val peoples = listOf(Person("Alice", 29), Person("Bob", 31))

//최대 나이 가져오기
fun main() {
    println(peoples.maxByOrNull { it.age })
    println(peoples.maxByOrNull(Person::age))
    // 람다, 더 간편하게 되어가는 과정
    println(peoples.maxByOrNull { p: Person -> p.age })
    println(peoples.maxByOrNull() { p: Person -> p.age }) //관습적으로 함수 호출 시 맨 뒤에 있는 인자가 람다 식이라면, 그 람다를 밖으로 빼낼 수 있다.
    println(peoples.maxByOrNull { p:Person -> p.age })  //람다가 어떤 함수의 유일한 인자 && 괄호 뒤에 람다를 썼다면 호출 시 빈 괄호흘 없애도 된다.
    println(peoples.maxByOrNull { p -> p.age }) //parameter type을 컴파일러가 추론해주기도 함
}