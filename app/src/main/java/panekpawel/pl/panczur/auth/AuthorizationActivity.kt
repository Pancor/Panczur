package panekpawel.pl.panczur.auth

import android.os.Bundle
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import panekpawel.pl.panczur.R
import panekpawel.pl.panczur.auth.signIn.SignInFragment
import panekpawel.pl.panczur.auth.signUp.SignUpFragment
import javax.inject.Inject

class AuthorizationActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var signInProvider: Lazy<SignInFragment>

    @Inject
    lateinit var signUpProvider: Lazy<SignUpFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_authorization)
    }
}
