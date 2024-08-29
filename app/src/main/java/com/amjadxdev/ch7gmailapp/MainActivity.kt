package com.amjadxdev.ch7gmailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amjadxdev.ch7gmailapp.components.GmailDrawerMenu
import com.amjadxdev.ch7gmailapp.components.GmailFab
import com.amjadxdev.ch7gmailapp.components.HomeAppBar
import com.amjadxdev.ch7gmailapp.components.HomeBottomMenu
import com.amjadxdev.ch7gmailapp.components.MailList
import com.amjadxdev.ch7gmailapp.ui.theme.GmailAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            GmailAppTheme {
                    GmailApp()
            }
        }
    }
}


@Composable
fun GmailApp() {
    val scaffoldState =  rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember {
        mutableStateOf(false)
    }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState,
            coroutineScope,
            openDialog) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },

        bottomBar = {
            HomeBottomMenu()
        },

        floatingActionButton = { GmailFab(scrollState) }
    )
    { innerPadding ->

    MailList(paddingValues = innerPadding, scrollState)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GmailAppTheme {
        GmailApp()
    }
}