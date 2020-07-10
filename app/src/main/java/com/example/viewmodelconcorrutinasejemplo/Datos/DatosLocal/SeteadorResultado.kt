package com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal

import com.example.viewmodelconcorrutinasejemplo.Datos.Usuario
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado

/**
 * Aquí estará el método que trabajará como un setter para la sealed class Resultado, lo cual nos permitirá la independencia de código
 * en caso de alguna modificación
 */

interface SeteadorResultado {

    suspend fun setearUsuario(): Resultado<Usuario>

}