package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import io.reactivex.Single
import panekpawel.pl.panczur.models.Result
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(val fireBaseAuth: FirebaseAuth) : AuthContract {

    companion object {
        const val SIGN_IN_SUCCEED = "SIGN_IN_SUCCEED"
        const val UNKNOWN_ERROR = "UNKNOWN_ERROR"
    }

    override fun signIn(email: String, password: String): Single<Result> {
        Timber.d("Email: $email, password: $password")
        return Single.create({ emitter ->
            fireBaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            emitter.onSuccess(Result(isSucceed = true, code = SIGN_IN_SUCCEED))
                            Timber.d("Sign in by email and password succeed")
                        } else {
                            val exception = it.exception as FirebaseAuthException
                            val result = handleSignInException(exception)
                            emitter.onSuccess(result)
                            Timber.d("Sign in by email and password returned error: " +
                                    result.code)
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