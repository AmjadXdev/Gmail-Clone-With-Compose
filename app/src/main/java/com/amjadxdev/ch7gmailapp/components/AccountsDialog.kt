package com.amjadxdev.ch7gmailapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.amjadxdev.ch7gmailapp.R
import com.amjadxdev.ch7gmailapp.accountList
import com.amjadxdev.ch7gmailapp.model.Account
import com.amjadxdev.ch7gmailapp.model.MailData

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
        ){
        AccountDialogUI(openDialog)
    }
}


@Composable
fun AccountDialogUI(openDialog: MutableState<Boolean>, modifier: Modifier = Modifier) {

    Card {
        Column(
            modifier
                .background(Color.White)
                .padding(16.dp)
        ) {

            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")

                }

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "",
                    modifier
                        .size(30.dp)
                        .weight(1f)
                )

            }

            /*            Row (
                            modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, top = 16.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.husky ),
                                contentDescription = "User Profile Image",
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                                    ,
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier
                                    .weight(1f)
                                    .padding(start = 16.dp, bottom = 16.dp)){
                                Text(text = "Amjad",
                                    fontWeight = FontWeight.Bold)

                                Text(text = "xyz@gmail.com")
                            }

                            Text(text = "99+", modifier.padding(end = 16.dp))
                        }*/

            AccountItem(account = accountList[0])
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                )
                {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = modifier.width(10.dp))
            }
            Divider(modifier.padding(16.dp))

            Column {
                AccountItem(account = accountList[1])
                AccountItem(account = accountList[2])
            }
            
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts")
            AddAccount(icon = Icons.Outlined.PersonAddAlt
                , title = "Add Another Account")

            Divider(modifier.padding(vertical = 16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){

                Text(text = "Privacy Policy")
                Card(modifier = Modifier
                    .padding(top = 10.dp)
                    .size(3.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color.Black)
                ){

                }

                Text(text = "Term Of Services")


            }
        }
    }
}

@Composable
fun AccountItem(account: Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {

        if (account.icon != null) {
            Image(
                painter = painterResource(id = R.drawable.husky),
                contentDescription = "User Profile Image",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )
        } else {
            androidx.compose.material.Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                backgroundColor = Color.Gray
            ) {

                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = account.userName,
                fontWeight = FontWeight.Bold
            )

            Text(text = account.email)
        }

        Text(
            text = "${account.unReadMails}+",
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}


@Composable
fun AddAccount(
    icon: ImageVector,
    title : String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        IconButton(onClick = {}) {
            Icon(imageVector = icon,
                contentDescription = "",
                Modifier.padding(bottom = 8.dp))

        }

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp),
            text = title,
                fontWeight = FontWeight.SemiBold
            )
    }

}

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    AccountDialogUI(openDialog = mutableStateOf(false))
}