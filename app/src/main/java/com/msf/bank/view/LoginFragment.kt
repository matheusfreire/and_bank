package com.msf.bank.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.msf.bank.R
import com.msf.bank.databinding.FragmentLoginBinding
import com.msf.bank.repository.RetrofitInstance
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        dataBinding.signInButton.setOnClickListener {
            //TODO Chamar api
        }
        return dataBinding.root
    }


}
