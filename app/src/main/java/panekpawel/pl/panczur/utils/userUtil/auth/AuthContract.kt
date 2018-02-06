package panekpawel.pl.panczur.utils.userUtil.auth

import io.reactivex.Single
import panekpawel.pl.panczur.models.Result


interface AuthContract {

    fun signIn(email: String, password: String): Single<Result>
}