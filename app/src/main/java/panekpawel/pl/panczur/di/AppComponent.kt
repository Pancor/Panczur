package panekpawel.pl.panczur.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import panekpawel.pl.panczur.base.App
import panekpawel.pl.panczur.utils.schedulers.SchedulerModule
import panekpawel.pl.panczur.utils.userUtil.UserModule
import panekpawel.pl.panczur.utils.userUtil.UserUtil
import panekpawel.pl.panczur.utils.userUtil.auth.AuthModule
import panekpawel.pl.panczur.utils.userUtil.auth.form.FormModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class),
    (ActivityBindingModule::class), (AuthModule::class), (UserModule::class),
    (SchedulerModule::class), (FormModule::class)])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    fun getUserUtil(): UserUtil

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance fun app(app: Application): Builder
    }
}