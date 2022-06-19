package chapter04

interface User {
    val nickName: String
}

class PrivateUser(override val nickName: String) : User //주 생성자에 있는 프로퍼티

class SubscribingUser(val email: String) : User {
    override val nickName: String
        get() = email.substringBefore('@') //custom getter
}

class FacebookUser(val accountId: Int): User{
    override val nickName = getFacebookName(accountId)
    private fun getFacebookName(accountId: Int): String {
        TODO()
    }
}

fun main(){
    println(PrivateUser("test@kotlinlang.org").nickName)
    println(SubscribingUser("test@kotlinlnag.org").nickName)
}