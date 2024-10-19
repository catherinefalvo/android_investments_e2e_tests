package com.example.myapplication.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InvestmentCard(code: String, earnings: String, amount: String, date: String, testTag: String, onMoreDetailsClick: () -> Unit = {} // adiciona um parâmetro com ação de clique
) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Detalhes do investimento") },
            text = { Text("Aqui estão mais informações sobre o investimento.") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                        onMoreDetailsClick()
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .testTag(testTag)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = code, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = earnings, color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = amount,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF9A825),
                    fontSize = 18.sp
                )
                Button(
                    onClick = { /* ação do botão */ },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(text = date, color = Color(0xFFF9A825), fontSize = 12.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = { showDialog.value = true }) {
                Text(text = "Mais detalhes", color = Color.Gray)
            }
        }
    }
}
