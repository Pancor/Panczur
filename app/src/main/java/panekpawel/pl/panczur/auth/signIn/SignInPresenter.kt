package panekpawel.pl.panczur.auth.signIn

import panekpawel.pl.panczur.base.BasePresenter
import panekpawel.pl.panczur.di.ActivityScope
import panekpawel.pl.panczur.utils.schedulers.BaseSchedulerProvider
import panekpawel.pl.panczur.utils.userUtil.UserContract
import javax.inject.Inject

@ActivityScope
class SignInPresenter @Inject constructor(val userUtil: UserContract,
                                          val schedulers: BaseSchedulerProvider) :
        BasePresenter<SignInContract.View>(), SignInContract.Presenter {

    override fun signIn(email: String, password: String) {
        disposable.add(userUtil.signIn(email, password)
                .observeOn(schedulers.ui())
                .subscribeOn(schedulers.io())
                .subscribe { result ->
                    if (result.isSucceed) {
                        view.verificationSuccess()
                    } else {
                        view.signInError(result.code)
                    }
                })
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