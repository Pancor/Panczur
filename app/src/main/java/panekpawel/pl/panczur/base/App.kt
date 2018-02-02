package panekpawel.pl.panczur.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import panekpawel.pl.panczur.di.DaggerAppComponent
import panekpawel.pl.panczur.utils.logger.Logger
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.startLogging()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .app(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }
}