package com.example.appmovie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun PantallaCatalogo(navController: NavController, viewModel: PeliculaViewModel) { // Corrección: 'viewModel' en minúscula

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Catálogo CineMatch", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Corrección: Usamos 'viewModel' en minúscula
            items(viewModel.peliculas) { pelicula ->
                ItemPelicula(pelicula = pelicula, navController = navController)
            }
        }
    }
}

@Composable
fun ItemPelicula(pelicula: Pelicula, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Corrección: Ruta cambiada a "detalles" (con 's') para coincidir con MainActivity
                navController.navigate("detalles/${pelicula.id}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = pelicula.urlImagen,
                contentDescription = "Portada de ${pelicula.titulo}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Le damos una altura fija
                    .clip(RoundedCornerShape(8.dp)), // Bordes un poco redondeados
                contentScale = ContentScale.Crop // Recorta la imagen para llenar el espacio sin deformarse
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(pelicula.titulo, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Director: ${pelicula.director}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Calificación: ${pelicula.clasificacion} | Año: ${pelicula.año}",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
