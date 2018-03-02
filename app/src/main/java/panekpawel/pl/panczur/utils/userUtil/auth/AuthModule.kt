package panekpawel.pl.panczur.utils.userUtil.auth

import dagger.Binds
import dagger.Module
import panekpawel.pl.panczur.utils.userUtil.auth.form.FormAuth
import javax.inject.Singleton

@Module
abstract class AuthModule {

    @Binds
    @Singleton
    abstract fun bindAuthManager(authManager: AuthManager): AuthContract

    @Binds
    @Singleton
    abstract fun bindeFormAuth(formAuth: FormAuth): AuthContract.Form
}