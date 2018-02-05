package panekpawel.pl.panczur.auth.signIn

import javax.inject.Inject

class SignInPresenter @Inject constructor() : SignInContract.Presenter {

    private lateinit var view: SignInContract.View

    override fun onSetView(view: SignInContract.View) {
        this.view = view
    }

    override fun signIn(email: String, password: String) {

    }

    override fun signInByFacebook() {

    }

    override fun signInByGoogle() {

    }

    override fun signUp() {

    }

    override fun restorePassword() {

    }
}