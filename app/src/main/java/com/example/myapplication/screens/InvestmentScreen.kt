package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .background(Color(0xFF1E1EFF))
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Total value at the top
        Text(
            text = "R$ 43,62",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // List of investments
        val investments = listOf(
            Investment("MXRF11", "Rendimento: R$ 0,09", "R$ 11,52", "DAQUI A 2 DIAS"),
            Investment("VISC11", "Rendimento: R$ 0,80", "R$ 10,40", "DAQUI A 2 DIAS"),
            Investment("RVBI11", "Rendimento: R$ 0,75", "R$ 18,75", "DAQUI A 3 DIAS"),
            Investment("CPTS11", "Rendimento: R$ 0,07", "R$ 2,95", "DAQUI A 5 DIAS"),
            Investment("MCHY11", "Rendimento: NÃO INFORMADO", "--", "NÃO INFORMADO")
        )

        // Dynamically create InvestmentCard components
        investments.forEach { investment ->
            InvestmentCard(
                code = investment.title,
                earnings = investment.rendimento,
                amount = investment.value,
                date = investment.date,
                testTag = investment.title
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
