package com.uam.scheduleapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.uam.scheduleapk.compose.AgendaApp
import com.uam.scheduleapk.ui.theme.ScheduleApkTheme

class MainCompose : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScheduleApkTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(title =  { Text(text = stringResource(R.string.title_activity_main_compose)) })
                        },
                        contentWindowInsets = WindowInsets.statusBars
                        ) { innerPadding ->
                            AgendaApp(innerPadding)
                }
            }
        }
    }
}
