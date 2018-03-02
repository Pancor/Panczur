package panekpawel.pl.panczur.utils.userUtil.auth.form

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import io.reactivex.Single
import panekpawel.pl.panczur.models.Result
import panekpawel.pl.panczur.utils.userUtil.auth.AuthContract
import panekpawel.pl.panczur.utils.userUtil.auth.AuthManager
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormAuth @Inject constructor(private val fireBaseAuth: FirebaseAuth): AuthContract.Form {

    override fun signIn(email: String, password: String): Single<Result> {
        Timber.d("Email: $email, password: $password")
        return Single.create({ emitter ->
            fireBaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            emitter.onSuccess(Result(isSucceed = true, code = AuthManager.SIGN_IN_SUCCEED))
                            Timber.d("Sign in by email and password succeed")
                        } else {
                            val exception = it.exception as FirebaseAuthException?
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
            return Result(isSucceed = false, code = AuthManager.UNKNOWN_ERROR)
        }
        return Result(isSucceed = false, code = exception.errorCode)
    }
}