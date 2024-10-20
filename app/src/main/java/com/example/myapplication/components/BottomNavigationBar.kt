package com.example.myapplication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class NavigationItem(val title: String, val icon: ImageVector)

@Composable
fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    val items = listOf(
        NavigationItem("Earnings", Icons.Filled.AttachMoney),
        NavigationItem("Wallet", Icons.Filled.Wallet)
    )

    NavigationBar(
        containerColor = Color(0xFFF5F5F5), // Light gray to soften the overall appearance
        contentColor = Color.Black,
        tonalElevation = 4.dp, // Lower elevation for a cleaner feel
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) // Rounded corners
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },  // Trigger tab switch
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title,
                        tint = if (selectedItem == index) Color(0xFF1E88E5) else Color.Gray // Blue for selected, Gray for unselected
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selectedItem == index) Color(0xFF1E88E5) else Color.Gray // Highlight active text in blue
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF1E88E5), // Blue for active icon
                    unselectedIconColor = Color.Gray, // Gray for inactive
                    selectedTextColor = Color(0xFF1E88E5), // Blue for active text
                    unselectedTextColor = Color.Gray // Gray for inactive text
                )
            )
        }
    }
}
