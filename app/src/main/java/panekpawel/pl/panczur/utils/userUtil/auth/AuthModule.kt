package panekpawel.pl.panczur.utils.userUtil.auth

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthModule {

    @Provides
    @Singleton
    fun provideAuthManager(): AuthContract {
        val auth = FirebaseAuth.getInstance()
        return AuthManager(auth)
    }
}