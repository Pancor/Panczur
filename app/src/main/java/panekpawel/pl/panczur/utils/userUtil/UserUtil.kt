package panekpawel.pl.panczur.utils.userUtil

import io.reactivex.Single
import panekpawel.pl.panczur.models.Result
import panekpawel.pl.panczur.utils.userUtil.auth.AuthContract
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUtil @Inject constructor(val authManager: AuthContract) : UserContract {

    override fun signIn(email: String, password: String): Single<Result> =
            authManager.signIn(email, password)
}