package com.msf.bank

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.msf.bank.util.ConvertUtil
import com.msf.bank.util.EspressIdlingResource
import com.msf.bank.view.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AccountFragmentTest {

    @Rule
    @JvmField
    val loginActivityActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private lateinit var mIdlingResource: IdlingResource

    @Before
    fun registerIdleResource(){
        mIdlingResource = EspressIdlingResource.getIdlingResource()
        IdlingRegistry.getInstance().register(mIdlingResource)
    }

    @Test
    fun testLoginSuccessful() {
        onView(withId(R.id.textEditUser)).perform(typeText("test_user"))
        onView(withId(R.id.textEditPassword)).perform(typeText("teste"))
        onView(withId(R.id.sign_in_button)).perform(click())
        onView(withId(R.id.account_name)).check(matches(withText("Jose da Silva Teste")))
        onView(withId(R.id.agencyWithBankAccount)).check(matches(withText(getValueBankAccountAndAgency())))
        onView(withId(R.id.balanceValue)).check(matches(withText(getBalanceValueFormatted())))
    }

    private fun getBalanceValueFormatted(): String {
        return ConvertUtil.getCurrencyBalance(3.3445)
    }

    private fun getValueBankAccountAndAgency(): String {
        return "012314564/2050"
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(mIdlingResource)
    }

}