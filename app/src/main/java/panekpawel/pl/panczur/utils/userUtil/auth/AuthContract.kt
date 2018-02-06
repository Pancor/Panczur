package panekpawel.pl.panczur.utils.userUtil.auth


interface AuthContract {

    fun signIn(email: String, password: String)
}