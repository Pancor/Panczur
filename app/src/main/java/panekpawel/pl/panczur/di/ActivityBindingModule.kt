package panekpawel.pl.panczur.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import panekpawel.pl.panczur.AuthorizationActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindAuthorizationActivity(): AuthorizationActivity
}