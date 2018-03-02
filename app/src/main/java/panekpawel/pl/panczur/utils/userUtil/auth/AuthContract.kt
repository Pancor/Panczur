package panekpawel.pl.panczur.utils.userUtil.auth

import io.reactivex.Single
import panekpawel.pl.panczur.models.Result


interface AuthContract {

    interface Form {
        fun signIn(email: String, password: String): Single<Result>
    }

    fun signIn(email: String, password: String): Single<Result>

    fun signInByFacebook(): Single<Result>
}