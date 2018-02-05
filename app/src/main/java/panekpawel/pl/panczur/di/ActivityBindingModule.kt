package panekpawel.pl.panczur.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import panekpawel.pl.panczur.auth.AuthorizationActivity
import panekpawel.pl.panczur.auth.AuthorizationModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(AuthorizationModule::class))
    abstract fun bindAuthorizationActivity(): AuthorizationActivity
}