package panekpawel.pl.panczur.auth.signIn

import java.io.File
import javax.xml.transform.Templates


class SignInPresenter : SignInContract.Presenter {

    lateinit var view: SignInContract.View

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