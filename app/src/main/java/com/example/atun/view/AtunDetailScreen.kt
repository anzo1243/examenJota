package com.example.atun.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.atun.data.AtunRojo
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtunDetailScreen(atunId: Int, navController: NavController, viewModel: AtunViewModel = viewModel()) {
    var atun by remember { mutableStateOf<AtunRojo?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(atunId) {
        viewModel.getAtunById(atunId).collectLatest { atun = it }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles del Atún") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (atun != null) {
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                Text(text = atun!!.nombre, style = MaterialTheme.typography.headlineMedium)
                Text(text = "Parte: ${atun!!.parteCuerpo}", style = MaterialTheme.typography.bodyLarge)
                Text(text = atun!!.descripcion, style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            Text(
                text = "No se encontró el atún",
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
