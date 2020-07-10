package com.example.viewmodelconcorrutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal.ImplementacionSR
import com.example.viewmodelconcorrutinasejemplo.Datos.DatosLocal.SeteadorResultado
import com.example.viewmodelconcorrutinasejemplo.Datos.DatosNube.BaseDatos
import com.example.viewmodelconcorrutinasejemplo.IU.ViewModel.MiViewModel
import com.example.viewmodelconcorrutinasejemplo.IU.ViewModel.MiViewModelFactory
import com.example.viewmodelconcorrutinasejemplo.ObjetosSealed.Resultado
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val miViewModel by lazy { ViewModelProvider(this, MiViewModelFactory(ImplementacionSR(BaseDatos()))).get(MiViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observarDatos()

    }

    fun observarDatos(){
        miViewModel.usuario.observe(this, Observer {resultado->
            when(resultado){
                is Resultado.Cargando ->{
                    mostrarBarraProgreso()
                }
                is Resultado.Exito ->{
                    textView.text = resultado.dato.nombre
                    esconderBarraProgreso()
                }
                is Resultado.Error ->{
                    Toast.makeText(this, "No se pudo conectar a la base de datos ${resultado.exception.message}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun mostrarBarraProgreso(){
        progressBar.visibility = View.VISIBLE
    }

    fun esconderBarraProgreso(){
        progressBar.visibility = View.GONE
    }
}