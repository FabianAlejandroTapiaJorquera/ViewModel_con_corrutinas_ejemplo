package com.example.viewmodelconcorrutinasejemplo.Datos.DatosNube

import com.example.viewmodelconcorrutinasejemplo.Datos.Usuario
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado

/**
 * Interfaz encargada de controlar los  métodos que traerán la información de la base de datos
 */

interface IBaseDatos {

    suspend fun obtenerUsuario(): Resultado<Usuario>

}