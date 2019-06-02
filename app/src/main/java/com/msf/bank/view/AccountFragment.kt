package com.msf.bank.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.msf.bank.R
import com.msf.bank.databinding.FragmentAccountBinding
import com.msf.bank.util.EspressIdlingResource
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
        getStatements()
        observeStatements()
        with(dataBinding.recyclerViewStatements) {
            layoutManager = LinearLayoutManager(context)
        }
        dataBinding.out.setOnClickListener {
            it.findNavController().navigateUp()
        }
        return dataBinding.root
    }

    private fun getLoginJson() {
        val args  = arguments?.let { AccountFragmentArgs.fromBundle(it) }
        bankViewModel.loginJson = args!!.loginJson
    }

    private fun setAccount() {
        dataBinding.account = bankViewModel.loginJson.account
    }

    private fun getStatements() {
        bankViewModel.callStatements()
    }

    private fun observeStatements() {
        bankViewModel.mutableLiveDataStatements.observe(this, Observer {
            if(it == null){

            } else {
                dataBinding.recyclerViewStatements.adapter = StatementsAdapter(it.statementList!!)
                showRecyclerView()
            }
        })
    }

    private fun showRecyclerView() {
        dataBinding.recyclerViewStatements.visibility = View.VISIBLE
        dataBinding.statementsProgress.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        EspressIdlingResource.decrement()
    }
}
