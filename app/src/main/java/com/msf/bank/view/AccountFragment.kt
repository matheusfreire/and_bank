package com.msf.bank.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.msf.bank.R
import com.msf.bank.databinding.FragmentAccountBinding
import com.msf.bank.viewmodel.BankViewModel

class AccountFragment : Fragment() {

    private lateinit var dataBinding: FragmentAccountBinding
    private lateinit var bankViewModel: BankViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false )
        bankViewModel = activity?.run {
            ViewModelProviders.of(this).get(BankViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        getLoginJson()
        setAccount()
        return dataBinding.root
    }

    private fun setAccount() {
        dataBinding.account = bankViewModel.loginJson.account
    }

    private fun getLoginJson() {
        val args  = arguments?.let { AccountFragmentArgs.fromBundle(it) }
        bankViewModel.loginJson = args!!.loginJson
    }


}
