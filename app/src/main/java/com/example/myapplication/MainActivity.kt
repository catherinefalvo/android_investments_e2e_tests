package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.components.BottomNavigationBar
import com.example.myapplication.screens.InvestmentScreen
import com.example.myapplication.screens.WalletScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Investment(
    val title: String,
    val rendimento: String,
    val value: String,
    val date: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                var selectedTab by remember { mutableIntStateOf(0) } // Track selected tab

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(selectedTab) { index ->
                            selectedTab = index // Update selected tab
                        }
                    }
                ) { paddingValues ->
                    when (selectedTab) {
                        0 -> InvestmentScreen(paddingValues = paddingValues)  // First tab
                        1 -> WalletScreen(paddingValues = paddingValues)      // Second tab
                    }
                }
            }
        }
    }
}