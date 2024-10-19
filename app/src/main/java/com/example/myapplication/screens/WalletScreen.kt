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
            .background(Color(0xFF1E1EFF))  // Keep the same background color
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())  // Enable vertical scrolling for the list
    ) {
        // Title section
        Text(
            text = "Minha Carteira",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // List of items in the wallet
        val walletAssetsItems = listOf(
            WalletAssetItem("MXRF11", "128 cotas"),
            WalletAssetItem("CPTS11", "41 cotas"),
            WalletAssetItem("MCHY11", "20 cotas"),
            WalletAssetItem("RVBI11", "25 cotas"),
            WalletAssetItem("VISC11", "18 cotas")
        )

        // Render each asset item using AssetItem
        walletAssetsItems.forEach { item ->
            WalletItem(item.code, item.quantity)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.weight(1f))  // Pushes the button to the bottom

        // Add button
        Button(
            onClick = { /* Add action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D19E)),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Adicione FIIs", fontWeight = FontWeight.Bold)
        }
    }
}
