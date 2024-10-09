
package com.supan.presentation.screens.home_screen.bottom_navigation_screen


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.supan.presentation.components.DefaultAppBar
import com.supan.presentation.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun SettingsPage() {


    ComposeChatAppTheme {
        Scaffold(
            topBar = {
                DefaultAppBar(
                    tabsNavController = null,
                    actions ={},
                    title = { Text(text = "Settings") },
                )
            },
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight().padding(top = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Implement your Settings")
            }
        }
    }

}

