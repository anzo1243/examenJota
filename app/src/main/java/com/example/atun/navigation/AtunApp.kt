package com.example.atun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.atun.view.AtunDetailScreen
import com.example.atun.view.AtunScreen

@Composable
fun AtunApp() {
    val navController = rememberNavController()
    AtunNavHost(navController)
}

@Composable
fun AtunNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "list") {
        composable("list") {
            AtunScreen(navController)
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                AtunDetailScreen(id, navController)
            }
        }
    }
}
