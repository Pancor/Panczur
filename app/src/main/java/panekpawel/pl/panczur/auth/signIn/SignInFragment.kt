package panekpawel.pl.panczur.auth.signIn

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import panekpawel.pl.panczur.R

class SignInFragment : Fragment(), SignInContract.View {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fr_sign_in, container, false)

    override fun showLoadingIndicator() {
        
    }

    override fun hideLoadingIndicator() {
        
    }

    override fun verificationSuccess() {
         
    }

    override fun signInError(message: String) {
        
    }
}