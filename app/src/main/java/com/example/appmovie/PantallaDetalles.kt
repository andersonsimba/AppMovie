package com.example.appmovie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
fun PantallaDetalles(
    navController: NavController,
    viewModel: PeliculaViewModel,
    peliculaId: Int
) {

    val pelicula = viewModel.obtenerPeliculaPorId(peliculaId)

    if (pelicula != null) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {

            Text(
                pelicula.titulo,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )



            Text(
                "Director: ${pelicula.director}",
                color = MaterialTheme.colorScheme.secondary
            )
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

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                "Sinopsis:",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                pelicula.sinopsis,
                style = MaterialTheme.typography.bodyLarge
            )
            Button(
                onClick = {
                    navController.popBackStack() },

            ) {
                Text("Volver al Catalogo")
            }
        }
    }else{
        Column(modifier = Modifier.fillMaxSize().padding(all = 16.dp)){
        Text(
            "Pelicula no encontrada",
            fontSize = 24 .sp,
            color = MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController.popBackStack()}) {
            Text("Volver")
        }
        }
    }
}




