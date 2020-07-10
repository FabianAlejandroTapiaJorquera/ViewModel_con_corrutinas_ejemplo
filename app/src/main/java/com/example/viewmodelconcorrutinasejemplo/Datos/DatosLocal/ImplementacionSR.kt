package com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal

import com.example.viewmodelconcorrutinasejemplo.Datos.DatosNube.IBaseDatos
import com.example.viewmodelconcorrutinasejemplo.Datos.Usuario
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado

/**
 * Aquí se implementan los métodos de la interfaz SeteadorResultado
 */

class ImplementacionSR(private val baseDatos: IBaseDatos): SeteadorResultado {
    override suspend fun setearUsuario(): Resultado<Usuario> {
       return baseDatos.obtenerUsuario()
    }
}