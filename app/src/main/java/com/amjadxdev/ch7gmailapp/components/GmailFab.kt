package com.amjadxdev.ch7gmailapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState: ScrollState) {

    if (scrollState.value > 100) {
        ExtendedFloatingActionButton(
            text = { 
                Text(text = "Compose", fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp))
            },
            icon = {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "")
            },
            onClick = { /*TODO*/ })
    }

    FloatingActionButton(onClick = { /*TODO*/ },
        backgroundColor = MaterialTheme.colorScheme.surface) {
        Icon(imageVector = Icons.Default.Edit,
            contentDescription = "")
    }
}


@Preview(showBackground = true)
@Composable
private fun GmailFabPreview() {
//    GmailFab()

}