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
//        // Check if the main amount "R$ 43,62" is displayed
//        composeTestRule
//            .onNodeWithText("R$ 43,62")
//            .assertIsDisplayed()
//
//        // Check if InvestmentCard for "MXRF11" is displayed with the correct values
//        composeTestRule
//            .onNodeWithText("MXRF11")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("Rendimento: R$ 0,09")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("R$ 11,52")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("DAQUI A 2 DIAS")
//            .assertIsDisplayed()
//
//        // Check if InvestmentCard for "VISC11" is displayed with the correct values
//        composeTestRule
//            .onNodeWithText("VISC11")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("Rendimento: R$ 0,80")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("R$ 10,40")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("DAQUI A 2 DIAS")
//            .assertIsDisplayed()
//
//        // Similarly, check for other InvestmentCards
//        composeTestRule
//            .onNodeWithText("RVBI11")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("Rendimento: R$ 0,75")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("R$ 18,75")
//            .assertIsDisplayed()
//        composeTestRule
//            .onNodeWithText("DAQUI A 3 DIAS")
//            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("CPTS11")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Rendimento: R$ 0,07")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("R$ 2,95")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("DAQUI A 5 DIAS")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("MCHY11")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Rendimento: NÃO INFORMADO")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("--")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("NÃO INFORMADO")
            .assertIsDisplayed()
    }

    @Test
    fun testVisibleMXRF11Components() {
        // Check if InvestmentCard for "MXRF11" is displayed with the correct values
        // Verify specific content inside the MXRF11 card
        composeTestRule
            .onNodeWithTag("MXRF11")
            .onChildren()
            .filter(hasText("Rendimento: R$ 0,09"))
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
            .filter(hasText("Rendimento: NÃO INFORMADO"))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag("MCHY11")
            .onChildren()
            .filter(hasText("--"))
            .assertCountEquals(1)

        composeTestRule
            .onNodeWithTag("MCHY11")
            .onChildren()
            .filter(hasText("NÃO INFORMADO"))
            .assertCountEquals(1)
    }
}
