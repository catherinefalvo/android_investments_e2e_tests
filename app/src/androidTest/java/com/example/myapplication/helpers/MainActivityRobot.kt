package com.example.myapplication.helpers

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

class MainActivityRobot(private val composeTestRule: ComposeTestRule) {

    // Function to click the "Proventos" tab
    fun clickOnProventosTab() {
        composeTestRule
            .onNodeWithText("Proventos")
            .performClick()
    }

    // Function to click the "Carteira" tab
    fun clickOnCarteiraTab() {
        composeTestRule
            .onNodeWithText("Carteira")
            .performClick()
    }

    // Function to verify if an investment card is displayed based on its tag
    fun verifyInvestmentCardIsDisplayed(tag: String) {
        composeTestRule
            .onNodeWithTag(tag)
            .assertIsDisplayed()
    }

    // Function to verify if an entry is displayed in the Wallet
    fun verifyWalletEntryIsDisplayed(entryText: String) {
        composeTestRule
            .onNodeWithText(entryText)
            .assertIsDisplayed()
    }
}
