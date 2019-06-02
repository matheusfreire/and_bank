package com.msf.bank.util

import android.annotation.SuppressLint
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object ConvertUtil {

    private val locale = Locale("pt", "BR")

    fun getCurrencyBalance(value: Double): String{
        val format = NumberFormat.getCurrencyInstance(locale)
        return format.format(value)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateFormatted(value: String): String{
        val date =  SimpleDateFormat("yyyy-MM-dd").parse(value)
        val formatted = SimpleDateFormat("dd/MM/yy", locale)
        return formatted.format(date)
    }
}