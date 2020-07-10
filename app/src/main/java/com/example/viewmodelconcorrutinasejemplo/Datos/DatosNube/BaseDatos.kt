package com.example.viewmodelconcorrutinasejemplo.Datos.DatosNube

import com.example.viewmodelconcorrutinasejemplo.Datos.Usuario
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado

/**
 * Aquí se realizan todas las operaciones de Firebase para obtener el usuario actual
 */

class BaseDatos: IBaseDatos {

    override suspend fun obtenerUsuario(): Resultado<Usuario> {
        return Resultado.Exito(Usuario("Fabian"))
    }
}