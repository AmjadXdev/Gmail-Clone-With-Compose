package com.amjadxdev.ch7gmailapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amjadxdev.ch7gmailapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeAppBar(scaffoldState: ScaffoldState,
               scope : CoroutineScope,
               openDialog : MutableState<Boolean>,
               modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .padding(10.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier
                .requiredHeight(50.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {

                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {

                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "Menu" )
                }


                Text(text = "Search an emails",
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 8.dp))

                Image(painter = painterResource(id = R.drawable.husky ),
                    contentDescription = "User Profile Image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .clickable {
                            openDialog.value = true
                        },
                    contentScale = ContentScale.Crop
                    )

                if (openDialog.value == true){
                    AccountsDialog(openDialog = openDialog)
                }

            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeAppBarPreview() {
//    HomeAppBar()

}