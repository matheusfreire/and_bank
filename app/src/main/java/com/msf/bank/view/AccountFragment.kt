package com.msf.bank.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.msf.bank.R
import com.msf.bank.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private lateinit var dataBinding: FragmentAccountBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false )
        return dataBinding.root
    }


}
