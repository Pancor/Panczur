package panekpawel.pl.panczur.auth.signUp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import panekpawel.pl.panczur.R
import panekpawel.pl.panczur.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class SignUpFragment @Inject constructor(): DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fr_sign_up, container, false)
}