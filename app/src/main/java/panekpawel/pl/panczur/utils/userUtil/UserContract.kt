package panekpawel.pl.panczur.utils.userUtil

import io.reactivex.Single
import panekpawel.pl.panczur.models.Result

interface UserContract {

    fun signIn(email: String, password: String): Single<Result>
}