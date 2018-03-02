package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import io.reactivex.Single
import panekpawel.pl.panczur.models.Result
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(private val formAuth: AuthContract.Form) : AuthContract {

    companion object {
        const val SIGN_IN_SUCCEED = "SIGN_IN_SUCCEED"
        const val UNKNOWN_ERROR = "UNKNOWN_ERROR"
    }

    override fun signIn(email: String, password: String) = formAuth.signIn(email, password)


    override fun signInByFacebook(): Single<Result> {
        return Single.create({})
    }
}