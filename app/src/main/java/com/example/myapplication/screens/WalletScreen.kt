package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.components.WalletItem

data class WalletAssetItem(
    val code: String,
    val quantity: String
)

@Composable
fun WalletScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF23374D), // Deep blue for top
                        Color(0xFF374B73)  // Softer blue towards bottom
                    )
                )
            )
            .padding(paddingValues)
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())  // Enable vertical scrolling for the list
    ) {
        Text(
            text = "My Wallet",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val walletAssetsItems = listOf(
            WalletAssetItem("MXRF11", "128 shares"),
            WalletAssetItem("CPTS11", "41 shares"),
            WalletAssetItem("MCHY11", "20 shares"),
            WalletAssetItem("RVBI11", "25 shares"),
            WalletAssetItem("VISC11", "18 shares")
        )

        // Render each asset item using AssetItem
        walletAssetsItems.forEach { item ->
            WalletItem(item.code, item.quantity)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.weight(1f))  // Pushes the button to the bottom

        Button(
            onClick = { /* Add action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA000) // Vibrant orange color for visibility
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(8.dp), // Added elevation for a 3D effect
            shape = RoundedCornerShape(12.dp) // Rounded corners for a modern look
        ) {
            Text(
                text = "Add investments",
                fontWeight = FontWeight.Bold,
                color = Color.White // White text for better contrast
            )
        }
    }
}
