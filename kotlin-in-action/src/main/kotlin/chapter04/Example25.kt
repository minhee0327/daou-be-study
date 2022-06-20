package chapter04

// 부생성자가 여럿 있는 클래스 정의하기
/*
class User2{
    val nickname: String

    constructor(email: String){
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int){
        nickname = getFacebookName(facebookAccountId)
    }

    private fun getFacebookName(facebookAccountId: Int): String {
        TODO()
    }
}*/


class User2 private constructor(val nickname: String){

    companion object{
        fun newSubscribingUser(email:String) = User2(email.substringBefore('@'))
        fun newFacebookUser(facebookAccountId: Int) = User2(getFacebookName(facebookAccountId))

        private fun getFacebookName(facebookAccountId: Int): String {
            TODO()
        }
    }
}