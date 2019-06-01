package com.msf.bank.util

import com.msf.bank.viewmodel.BankViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface Injector {
    fun inject(bankViewModel: BankViewModel)

    @Component.Builder
    interface Builder {
        fun build(): Injector

        fun networkModule(retrofitModule: RetrofitModule): Builder
    }
}