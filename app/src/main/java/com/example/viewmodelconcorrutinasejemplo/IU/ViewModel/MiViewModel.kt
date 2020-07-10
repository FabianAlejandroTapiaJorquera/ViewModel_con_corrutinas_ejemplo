package com.example.viewmodelconcorrutinasejemplo.IU.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal.SeteadorResultado
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado
import kotlinx.coroutines.Dispatchers

class MiViewModel(miResultado: SeteadorResultado): ViewModel(){
    /**
     * El valor de usuario dependerá de si se falla o tiene exito al cargar los datos de Firebase
     */
    val usuario = liveData(Dispatchers.IO) {
        emit(Resultado.Cargando())
        try {
            emit(miResultado.setearUsuario())
        } catch(e: Exception) {
            emit(Resultado.Error(e))
        }
    }
}