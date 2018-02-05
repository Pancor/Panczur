package panekpawel.pl.panczur.auth.signIn

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fr_sign_in.*
import panekpawel.pl.panczur.R
import panekpawel.pl.panczur.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class SignInFragment @Inject constructor() : DaggerFragment(), SignInContract.View {

    @Inject
    lateinit var presenter: SignInContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fr_sign_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSignInButton()
    }

    private fun setupSignInButton() {
        signInBtn.setOnClickListener {
            val email = emailInputView.text.toString()
            val password = passwordInputView.text.toString()
            presenter.signIn(email, password)
        }
    }

    override fun showLoadingIndicator() {
        
    }

    override fun hideLoadingIndicator() {
        
    }

    override fun verificationSuccess() {
         
    }

    override fun signInError(message: String) {
        
    }
}