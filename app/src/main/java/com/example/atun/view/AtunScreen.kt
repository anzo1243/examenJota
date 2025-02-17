package com.example.atun.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atun.data.AtunRojo
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtunScreen(navController: NavController, viewModel: AtunViewModel = viewModel()) {
    val atunList by viewModel.atunList.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Atún Rojo") }) }
    ) { paddingValues ->
        if (atunList.isEmpty()) {
            Text(
                text = "No hay datos disponibles",
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(atunList) { atun ->
                    AtunItem(atun) {
                        navController.navigate("detail/${atun.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun AtunItem(atun: AtunRojo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = atun.nombre,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(text = "Parte: ${atun.parteCuerpo}", style = MaterialTheme.typography.bodyMedium)
            Text(text = atun.descripcion, style = MaterialTheme.typography.bodySmall)
        }
    }
}
