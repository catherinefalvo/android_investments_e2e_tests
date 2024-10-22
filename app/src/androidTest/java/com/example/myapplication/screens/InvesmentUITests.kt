package com.example.myapplication.screens

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testMainActivityUIComponents() {
        // Check if the main amount "R$ 43,62" is displayed
        composeTestRule
            .onNodeWithText("R$ 43,62")
            .assertIsDisplayed()

        // Check if InvestmentCard for "MXRF11" is displayed with the correct values
        composeTestRule
            .onNodeWithText("MXRF11")
            .onParent() // Limit the scope to the parent card containing "MXRF11"
            .assertIsDisplayed()
            .onChildren() // Narrow down the children inside this card
            .filterToOne(hasText("Earnings: R$ 0.09"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("MXRF11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("R$ 11.52"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("MXRF11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("IN 2 DAYS"))
            .assertIsDisplayed()

        // Check if InvestmentCard for "VISC11" is displayed with the correct values
        composeTestRule
            .onNodeWithText("VISC11")
            .onParent()
            .assertIsDisplayed()
            .onChildren()
            .filterToOne(hasText("Earnings: R$ 0.80"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("VISC11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("R$ 10.40"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("VISC11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("IN 2 DAYS"))
            .assertIsDisplayed()

        // Similarly, check for other InvestmentCards
        composeTestRule
            .onNodeWithText("RVBI11")
            .onParent()
            .assertIsDisplayed()
            .onChildren()
            .filterToOne(hasText("Earnings: R$ 0.75"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("RVBI11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("R$ 18.75"))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("RVBI11")
            .onParent()
            .onChildren()
            .filterToOne(hasText("IN 3 DAYS"))
            .assertIsDisplayed()

    }

    @Test
    fun testVisibleMXRF11Components() {
        // Check if InvestmentCard for "MXRF11" is displayed with the correct values
        // Verify specific content inside the MXRF11 card
        composeTestRule
            .onNodeWithTag("MXRF11")
            .onChildren()
            .filter(hasText("Earnings: R$ 0.09"))
            .assertCountEquals(1)
    }

    @Test
    fun testScrollToLastInvestmentCard() {
        // Scroll to the last investment card "MCHY11"
        composeTestRule
            .onNodeWithTag("MCHY11")
            .performScrollTo()  // Scroll to the node with the tag "MCHY11"

        // Verify the last investment card is displayed
        composeTestRule
            .onNodeWithTag("MCHY11")
            .assertIsDisplayed()

        // Verify specific content in the last investment card
        composeTestRule
            .onNodeWithTag("MCHY11")
            .onChildren()
            .filter(hasText("Earnings: NOT INFORMED"))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag("MCHY11")
            .onChildren()
            .filter(hasText("--"))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag("MCHY11")
            .onChildren()
            .filter(hasText("NOT INFORMED"))
            .assertCountEquals(1)
    }
}
