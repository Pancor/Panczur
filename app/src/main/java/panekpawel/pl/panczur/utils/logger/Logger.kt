package panekpawel.pl.panczur.utils.logger

import android.util.Log
import com.crashlytics.android.Crashlytics
import panekpawel.pl.panczur.BuildConfig
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Logger @Inject constructor(){

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    private class CrashReportingTree : Timber.Tree() {

        override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            Crashlytics.log(priority, tag, message)
            if (t != null) {
                if (priority == Log.ERROR || priority == Log.WARN) {
                    Crashlytics.logException(t)
                }
            }
        }
    }
}