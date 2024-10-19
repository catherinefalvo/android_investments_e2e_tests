package com.example.myapplication.screens

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTestCleaner {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Helper function to check that an investment card is displayed
    private fun verifyInvestmentCardDisplayed(title: String, rendimento: String, value: String, date: String) {
        composeTestRule
            .onNodeWithTag(title)
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(title)
            .onChildren()
            .filter(hasText(rendimento))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag(title)
            .onChildren()
            .filter(hasText(value))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag(title)
            .onChildren()
            .filter(hasText(date))
            .assertCountEquals(1)
    }

    @Test
    fun testMainActivityUIComponents() {
        // Verify InvestmentCard for "CPTS11"
        verifyInvestmentCardDisplayed(
            title = "CPTS11",
            rendimento = "Rendimento: R$ 0,07",
            value = "R$ 2,95",
            date = "DAQUI A 5 DIAS"
        )

        // Verify InvestmentCard for "MCHY11"
        verifyInvestmentCardDisplayed(
            title = "MCHY11",
            rendimento = "Rendimento: NÃO INFORMADO",
            value = "--",
            date = "NÃO INFORMADO"
        )
    }

    @Test
    fun testVisibleActivityUIComponents() {
        // Check if specific content inside the MXRF11 card is displayed
        composeTestRule
            .onNodeWithTag("MXRF11")
            .onChildren()
            .filter(hasText("Rendimento: R$ 0,09"))
            .assertCountEquals(1)
    }

    @Test
    fun testScrollToLastInvestmentCard() {
        // Scroll to the last investment card "MCHY11"
        // Verify the last investment card "MCHY11" is displayed
        verifyInvestmentCardDisplayed(
            title = "MCHY11",
            rendimento = "Rendimento: NÃO INFORMADO",
            value = "--",
            date = "NÃO INFORMADO"
        )
    }
}
