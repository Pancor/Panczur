package panekpawel.pl.panczur.auth

import dagger.Module
import dagger.android.ContributesAndroidInjector
import panekpawel.pl.panczur.auth.signIn.SignInFragment
import panekpawel.pl.panczur.auth.signUp.SignUpFragment
import panekpawel.pl.panczur.di.FragmentScope

@Module
abstract class AuthorizationModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun signInFragment(): SignInFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun signUpFragment(): SignUpFragment
}