package com.msf.bank.view


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.msf.bank.R
import com.msf.bank.databinding.FragmentLoginBinding
import com.msf.bank.viewmodel.BankViewModel

class LoginFragment : Fragment() {

    private lateinit var dataBinding: FragmentLoginBinding
    private lateinit var bankViewModel: BankViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        bankViewModel = activity?.run {
            ViewModelProviders.of(this).get(BankViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        dataBinding.signInButton.setOnClickListener {
            if(validateInputs()){
                showProgress(true)
                makeCallToLogin()
            }
        }
        bankViewModel.mutableLiveData.observe(this, Observer {
            if (it == null){
                showLoginError()
            } else {
                dataBinding.root.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment(it))
            }
        })
        return dataBinding.root
    }

    private fun showLoginError() {
        Snackbar.make(dataBinding.root, getString(R.string.an_error_has_occurred), Snackbar.LENGTH_LONG).show()
    }

    private fun showProgress(showProgres: Boolean) {
        dataBinding.loginForm.visibility = if (showProgres) View.GONE else View.VISIBLE
        dataBinding.loginProgress.visibility = if(showProgres) View.VISIBLE else View.GONE
    }

    private fun validateInputs(): Boolean {
        val fieldEmpty:String = getString(R.string.field_empty)
        if(TextUtils.isEmpty(dataBinding.textEditUser.text)){
            dataBinding.textEditUser.error = fieldEmpty
            return false
        }
        if (TextUtils.isEmpty(dataBinding.textEditPassword.text)) {
            dataBinding.textEditPassword.error = fieldEmpty
            return false
        }
        return true
    }

    private fun makeCallToLogin() {
        bankViewModel.callLogin(dataBinding.textEditUser.text.toString(), dataBinding.textEditPassword.text.toString())
    }
}
