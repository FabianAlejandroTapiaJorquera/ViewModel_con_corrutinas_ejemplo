package com.example.viewmodelconcorrutinasejemplo.ObjetosSealed

import java.lang.Exception


/**
 * Clase sellada que puede contener cualquier tipo de dato
 * Se utilizará esta clase para manejar los resultados de los datos que obtendremos de Firestore
 * Con este objeto sabremos cuando esta cargando el recurso, cuando hubo exito en la carga y cuando no se pudo traer datos
 */
sealed class Resultado<out T> {
    class Cargando<out T>: Resultado<T>()
    data class Exito<out T>(val dato: T): Resultado<T>()
    data class Error<out T>(val exception: Exception): Resultado<T>()
}