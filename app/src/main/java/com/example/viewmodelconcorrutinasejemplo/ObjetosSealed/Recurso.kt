package com.example.viewmodelconcorrutinasejemplo.ObjetosSealed

import java.lang.Exception


/**
 * Clase sellada que puede contener cualquier tipo de dato
 * Se utilizará esta clase para manejar los resultados de los datos que obtendremos de Firestore
 * Con este sabremos cuando esta cargando el recurso, cuando hubo exito en la carga y cuando no se pudo traer datos
 */
sealed class Recurso<out T> {
    class Cargando<out T>: Recurso<T>()
    data class Exito<out T>(val dato: T): Recurso<T>()
    data class Fallar<out T>(val exception: Exception): Recurso<T>()
}