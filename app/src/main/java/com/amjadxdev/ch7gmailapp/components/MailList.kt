package com.amjadxdev.ch7gmailapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amjadxdev.ch7gmailapp.mailList
import com.amjadxdev.ch7gmailapp.model.MailData

@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {

    Box(modifier = Modifier.padding(paddingValues)){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            items(mailList) { mailList ->
                MailItem(mailData = mailList)
            }

        }
    }
    
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            backgroundColor = Color.Gray
        ) {

            Text(text = mailData.userName[0].toString(),
                textAlign = TextAlign.Center,
                modifier = modifier.padding(8.dp))
        }

        Column(
            modifier.weight(2.0f)
        ) {
            Text(text = mailData.userName, fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = mailData.subject, fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = mailData.body, fontSize = 14.sp,
                maxLines = 2
            )

        }

        Column(modifier.weight(.4f)) {
            Text(text = mailData.timeStamp)
            IconButton(onClick = { },
                modifier = Modifier
                    .size(50.dp)
                    .padding(16.dp)) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "Favorite")


            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MailListPreview() {

//       Scaffold {
//           MailList(paddingValues = it)
//       }

}