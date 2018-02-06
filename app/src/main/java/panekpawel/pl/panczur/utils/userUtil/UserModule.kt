package panekpawel.pl.panczur.utils.userUtil

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UserModule {

    @Binds
    @Singleton
    abstract fun bindUserUtil(userUtil: UserUtil): UserContract
}