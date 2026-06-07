package com.example.appmovie

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PeliculaViewModel : ViewModel() {

    private val _peliculas = mutableStateListOf(
        Pelicula(
            id = 1,
            titulo = "El Rey León",
            director = "Rob Minkoff",
            año = 1994,
            descripcion = "Película animada de Disney",
            sinopsis = "Un joven león príncipe huye de su reino tras la muerte de su padre, solo para aprender el verdadero significado de la responsabilidad.",
            clasificacion = 8.5,
            urlImagen ="https://static.posters.cz/image/350/posters/el-rey-leon-one-sheet-i76297.jpg"
        ),

        Pelicula(
            id = 2,
            titulo = "Inception (El Origen)",
            director = "Christopher Nolan",
            año = 2010,
            descripcion = "Película de ciencia ficción y suspenso",
            sinopsis = "A un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños se le da la tarea de plantar una idea.",
            clasificacion = 8.8,
            urlImagen = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3N4H9nL0oIYXBerCPT_yPFsm4f85_6fYSog&s"
        ),

        Pelicula(
            id = 3,
            titulo = "Avatar",
            director = "James Cameron",
            año = 2009,
            descripcion = "Película de ciencia ficción y aventura",
            sinopsis = "Un parapléjico enviado a una misión en el lejano mundo de Pandora se debate entre seguir órdenes y proteger al mundo que siente que es su hogar.",
            clasificacion = 7.9,
            urlImagen ="https://m.media-amazon.com/images/I/61l4F+4vu8L._AC_UF894,1000_QL80_.jpg"
        ),

        Pelicula(
            id = 4,
            titulo = "Spiderman: Into the Spider-Verse",
            director = "Bob Persichetti",
            año = 2018,
            descripcion = "Película animada de superhéroes",
            sinopsis = "El adolescente Miles Morales se convierte en el Spider-Man de su universo y debe unirse a otros héroes arácnidos de varias dimensiones.",
            clasificacion = 8.4,
            urlImagen = "https://i.pinimg.com/736x/c1/c9/9b/c1c99bdbda277ebb4f98b12f498a5520.jpg"
        )
    )

    val peliculas: List<Pelicula>
        get() = _peliculas

    fun obtenerPeliculaPorId(id: Int): Pelicula? {
        return _peliculas.find { it.id == id }
    }
}