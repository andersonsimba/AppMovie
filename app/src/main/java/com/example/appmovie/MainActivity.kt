package com.example.appmovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Importación corregida con 'p' minúscula cabio en hithub
import com.example.appmovie.ui.theme.AppMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Nombre de la función corregido a AppMovieTheme
            AppMovieTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CineMatchApp()
                }
            }
        }
    }
}

@Composable
fun CineMatchApp() {
    val navController = rememberNavController()
    val peliculaViewModel: PeliculaViewModel = viewModel()

    NavHost(navController = navController, startDestination = "catalogo") {

        composable(route = "catalogo") {
            // Parámetro corregido a minúscula 'viewModel'
            PantallaCatalogo(navController = navController, viewModel = peliculaViewModel)
        }

        composable(route = "detalles/{id}") { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("id")
            val idInt = idString?.toIntOrNull() ?: 0

            // Parámetro corregido a minúscula 'viewModel'
            PantallaDetalles(
                navController = navController,
                viewModel = peliculaViewModel,
                peliculaId = idInt
            )
        }
    }
}
