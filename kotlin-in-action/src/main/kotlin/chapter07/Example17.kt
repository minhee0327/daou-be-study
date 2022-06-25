package chapter07

class Email{}

/*
* 자신이 작성한 이메일 목록 을 db에서 가져온다.
* */
fun loadEmails(person: Person2): List<Email>{
    println("${person.name} 의 이메일을 가져옴")
    return listOf()
}

//지연 초기화를 뒷받침하는 프로퍼티를 통해 구현하기
class Person2(val name: String){
    private var _emails : List<Email>? = null //데이터를 저장하고 emails의 위임 객체를 연결하는 _emails 프로퍼티
    val emails: List<Email>
        get(){
            if(_emails == null){
                _emails = loadEmails(this) //최초 접근시 이메일을 가져온다.
            }
            return _emails!!  //저장해둔 데이터가 있으면 그 데이터 반환
        }
}


fun main(){
    val p = Person2("Alice")
    p.emails //최초로 emails 를 읽을때 단한번만 이메일을 가져온다.
}