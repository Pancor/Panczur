package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import panekpawel.pl.panczur.models.Result

class AuthManagerTest {

    @Mock
    private lateinit var fireBaseAuth: FirebaseAuth

    @Mock
    private lateinit var authResult: Task<AuthResult>

    private lateinit var authManager: AuthManager

    private val EMAIL = "email@email.email"
    private val PASSWORD = "password"

    @Before
    fun setupAuthManager() {
        MockitoAnnotations.initMocks(this)
        authManager = AuthManager(fireBaseAuth)
    }

    @Test
    fun signInByEmailAndPasswordWithSuccessThenCheckIfResultSucceeds() {
        whenever(authResult.isSuccessful).thenReturn(true)
        whenever(fireBaseAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)).thenReturn(authResult)

        doAnswer {
            val listener = it.arguments[0] as OnCompleteListener<AuthResult>
            listener.onComplete(authResult)
            authResult
        }.`when`(authResult)
                .addOnCompleteListener(ArgumentMatchers.any<OnCompleteListener<AuthResult>>())

        val expectedResult = Result(isSucceed = true, code = AuthManager.SIGN_IN_SUCCEED)

        val testObserver = authManager.signIn(EMAIL, PASSWORD)
                .test()
        testObserver.awaitTerminalEvent()

        testObserver
                .assertNoErrors()
                .assertValue(expectedResult)
    }
}