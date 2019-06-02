package com.msf.bank

import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.msf.bank.view.MainActivity
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Rule
    @JvmField
    val loginActivityActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewIsCreated() {
        onView(withId(R.id.textEditUser)).check(matches(isDisplayed()))
        onView(withId(R.id.textEditPassword)).check(matches(isDisplayed()))
    }
}