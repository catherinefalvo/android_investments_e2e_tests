package com.example.myapplication.cases

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.MainActivity
import com.example.myapplication.helpers.MainActivityRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityE2EAssetTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val robot = MainActivityRobot(composeTestRule)  // Use the robot to interact with UI

    @Test
    fun testMXRF11OnInvestmentAndWalletScreen() {
        // Step 1: Check MXRF11 on Investment Screen
        robot.clickOnEarningsTab()
        robot.verifyInvestmentCardIsDisplayed("MXRF11")

        // Step 2: Switch to Wallet Screen
        robot.clickOnWalletTab()
        robot.verifyWalletEntryIsDisplayed("MXRF11")
    }
}
