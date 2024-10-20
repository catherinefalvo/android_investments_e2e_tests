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
fun InvestmentCard(
    code: String,
    earnings: String,
    amount: String,
    date: String,
    testTag: String,
    modifier: Modifier = Modifier, // Modifier passed from external layout
    onMoreDetailsClick: () -> Unit = {}
) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Investment Details") },
            text = { Text("Here is more information about the investment.") },
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
        shape = RoundedCornerShape(12.dp), // More modern rounded corners
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), // Increased elevation for pop effect
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)), // Softer card background
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .testTag(testTag)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            // Investment Code
            Text(
                text = code,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1E88E5) // Strong blue for emphasis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Earnings info
            Text(
                text = earnings,
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Amount and Date Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Amount with a bolder font
                Text(
                    text = amount,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF9A825), // Yellow for contrast
                    fontSize = 22.sp
                )

                // Date in a button with better contrast
                Button(
                    onClick = { /* Action for the button */ },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(20.dp), // More modern rounded button
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                ) {
                    Text(
                        text = date,
                        color = Color(0xFFF9A825), // Same yellow as amount for consistency
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // More details button with higher contrast
            TextButton(
                onClick = { showDialog.value = true },
                modifier = Modifier.align(Alignment.End) // Align right for a cleaner layout
            ) {
                Text(
                    text = "More details",
                    color = Color(0xFF1E88E5), // Strong blue for the button
                    fontSize = 14.sp
                )
            }
        }
    }
}
