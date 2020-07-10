package com.example.viewmodelconcorrutinasejemplo.Datos.DatosNube

import androidx.lifecycle.MutableLiveData
import com.example.viewmodelconcorrutinasejemplo.Datos.Usuario
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Aquí se realizan todas las operaciones de Firebase para obtener el usuario actual
 */

class BaseDatos: IBaseDatos {

    override suspend fun obtenerUsuario(): Resultado<Usuario> {
        val nombreUsuario = FirebaseFirestore.getInstance().collection("usuarios")
            .document("19230622-1").get().await()
        val usuario = Usuario(nombreUsuario.get("nombre").toString())
        return Resultado.Exito(usuario)
    }
}