package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations
import panekpawel.pl.panczur.models.Result

class AuthManagerTest {

    private lateinit var authManager: AuthManager

    @Mock private lateinit var fireBaseAuth: FirebaseAuth
    @Mock private lateinit var authResult: Task<AuthResult>
    @Mock private lateinit var exception: FirebaseAuthException

    private val EMAIL = "email@email.email"
    private val PASSWORD = "password"
    private val ERROR_CODE = "error_code"

    @Before
    fun setupAuthManager() {
        MockitoAnnotations.initMocks(this)
        authManager = AuthManager(fireBaseAuth)
    }

    @Test
    @Suppress("UNCHECKED_CAST")
    fun signInByEmailAndPasswordWithSuccessThenCheckIfResultSucceeds() {
        whenever(authResult.isSuccessful).thenReturn(true)
        whenever(fireBaseAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)).thenReturn(authResult)
        callOnCompleteOfAuthResult()
        val expectedResult = Result(isSucceed = true, code = AuthManager.SIGN_IN_SUCCEED)

        val testObserver = authManager.signIn(EMAIL, PASSWORD)
                .test()
        testObserver.awaitTerminalEvent()

        testObserver
                .assertNoErrors()
                .assertValue(expectedResult)
    }

    @Test
    fun signInByEmailAndPasswordWithFailThenCheckIfResultFailsWithNull() {
        whenever(authResult.isSuccessful).thenReturn(false)
        whenever(authResult.exception).thenReturn(null)
        whenever(fireBaseAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)).thenReturn(authResult)
        callOnCompleteOfAuthResult()
        val expectedResult = Result(isSucceed = false, code = AuthManager.UNKNOWN_ERROR)

        val testObserver = authManager.signIn(EMAIL, PASSWORD)
                .test()
        testObserver.awaitTerminalEvent()

        testObserver
                .assertNoErrors()
                .assertValue(expectedResult)
    }

    @Test
    fun signInByEmailAndPasswordWithFailThenCheckIfResultFailsWithException() {
        whenever(authResult.isSuccessful).thenReturn(false)
        whenever(authResult.exception).thenReturn(exception)
        whenever(exception.errorCode).thenReturn(ERROR_CODE)
        whenever(fireBaseAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)).thenReturn(authResult)
        callOnCompleteOfAuthResult()
        val expectedResult = Result(isSucceed = false, code = ERROR_CODE)

        val testObserver = authManager.signIn(EMAIL, PASSWORD)
                .test()
        testObserver.awaitTerminalEvent()

        testObserver
                .assertNoErrors()
                .assertValue(expectedResult)
    }

    @Suppress("UNCHECKED_CAST")
    private fun callOnCompleteOfAuthResult() {
        doAnswer {
            val listener = it.arguments[0] as OnCompleteListener<AuthResult>
            listener.onComplete(authResult)
            authResult
        }.`when`(authResult)
                .addOnCompleteListener(ArgumentMatchers.any<OnCompleteListener<AuthResult>>())
    }
}