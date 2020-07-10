package com.example.viewmodelconcorrutinasejemplo.IU.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal.SeteadorResultado

class MiViewModelFactory(private val miResultado: SeteadorResultado): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SeteadorResultado::class.java).newInstance(miResultado)
    }
}