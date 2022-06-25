package chapter07

class Person3(val name: String){
    val emails by lazy{ loadEmails(this)}

    private fun loadEmails(person: Person3): List<Email> {
        println("${person.name} 의 이메일을 가져옴")
        return listOf()
    }
}