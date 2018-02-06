package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import io.reactivex.Single
import panekpawel.pl.panczur.models.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(val fireBaseAuth: FirebaseAuth) : AuthContract {

    companion object {
        const val SIGN_IN_SUCCEED = "sign_in_succeed"
        const val UNKNOWN_ERROR = "unknown_error"
    }

    override fun signIn(email: String, password: String): Single<Result> {
        return Single.create({ emitter ->
            fireBaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            emitter.onSuccess(Result(isSucceed = true, code = SIGN_IN_SUCCEED))
                        } else {
                            val exception = it.exception as FirebaseAuthException
                            emitter.onSuccess(handleSignInException(exception))
                        }
                    }
        })
    }

    private fun handleSignInException(exception: FirebaseAuthException?): Result {
        if (exception == null) {
            return Result(isSucceed = false, code = UNKNOWN_ERROR)
        }
        return Result(isSucceed = false, code = exception.errorCode)
    }
}