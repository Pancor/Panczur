package panekpawel.pl.panczur.auth.signIn

import panekpawel.pl.panczur.di.ActivityScope
import panekpawel.pl.panczur.utils.userUtil.UserContract
import javax.inject.Inject

@ActivityScope
class SignInPresenter @Inject constructor(val userUtil: UserContract) : SignInContract.Presenter {

    private lateinit var view: SignInContract.View

    override fun onSetView(view: SignInContract.View) {
        this.view = view
    }

    override fun signIn(email: String, password: String) {
        userUtil.signIn(email, password)
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