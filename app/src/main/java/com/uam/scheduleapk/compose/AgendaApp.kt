package com.uam.scheduleapk.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uam.scheduleapk.viewmodel.AgendaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AgendaApp(modifier: Modifier) {
    val agendaModel: AgendaViewModel =  viewModel()
    val collectState by agendaModel.state.collectAsState()

    if(collectState.loading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    LazyColumn (verticalArrangement = Arrangement.Center,
                 horizontalAlignment = Alignment.CenterHorizontally) {
             items(collectState.listAgenda){
                 Card(modifier = Modifier.fillMaxSize().padding(5.dp),
                     elevation = CardDefaults.cardElevation(8.dp)) {
                     Column(modifier = Modifier.fillMaxSize(),
                         verticalArrangement = Arrangement.Center,
                         horizontalAlignment = Alignment.Start) {
                         Text(text = it.nombreCliente, fontWeight = FontWeight.Bold)
                         Text(text = it.motivo)
                         Text(text = it.fecha)
                         Text(text = it.comentarios)
                     }
                 }
             }

    }
}