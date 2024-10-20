package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import com.example.myapplication.Investment
import com.example.myapplication.components.InvestmentCard

@Composable
fun InvestmentScreen(paddingValues: PaddingValues) {
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
            .verticalScroll(rememberScrollState())
    ) {
        // Total value at the top with improved typography
        Text(
            text = "Total Investments",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = Color.White.copy(alpha = 0.7f), // Softer white
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "R$ 43,62",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White, // More vibrant color for the total amount
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // List of investments with updated styling
        val investments = listOf(
            Investment("MXRF11", "Earnings: R$ 0.09", "R$ 11.52", "IN 2 DAYS"),
            Investment("VISC11", "Earnings: R$ 0.80", "R$ 10.40", "IN 2 DAYS"),
            Investment("RVBI11", "Earnings: R$ 0.75", "R$ 18.75", "IN 3 DAYS"),
            Investment("CPTS11", "Earnings: R$ 0.07", "R$ 2.95", "IN 5 DAYS"),
            Investment("MCHY11", "Earnings: NOT INFORMED", "--", "NOT INFORMED")
        )

        // Dynamically create InvestmentCard components with better visuals
        investments.forEach { investment ->
            InvestmentCard(
                code = investment.title,
                earnings = investment.rendimento,
                amount = investment.value,
                date = investment.date,
                testTag = investment.title,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}