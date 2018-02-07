package panekpawel.pl.panczur.auth.signIn

import panekpawel.pl.panczur.base.BasePresenterContract
import panekpawel.pl.panczur.base.BaseView

interface SignInContract {

    interface Presenter : BasePresenterContract<View> {

        fun signIn(email: String, password: String)

        fun signInByFacebook()

        fun signInByGoogle()

        fun signUp()

        fun restorePassword()
    }

    interface View : BaseView {

        fun verificationSuccess()

        fun signInError(message: String)
    }
}