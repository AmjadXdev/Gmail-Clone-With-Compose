package com.amjadxdev.ch7gmailapp.components

import android.graphics.drawable.Icon
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.amjadxdev.ch7gmailapp.model.BottomMenuData


@Composable
fun HomeBottomMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    BottomNavigation (
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                label = { Text(text = item.title)},
                alwaysShowLabel = true,
                selected = false,
                onClick = {},
                icon = { androidx.compose.material.Icon(
                imageVector = item.icon,
                contentDescription = item.title
            ) })

        }
    }
}