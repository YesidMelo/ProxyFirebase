package com.example.elvermelo.template.Repositorios.Firebase

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.elvermelo.template.Repositorios.Firebase.Modelos.Usuario
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.experimental.launch


/**
implementation 'com.google.firebase:firebase-core:16.0.6'
implementation 'com.google.firebase:firebase-auth:16.1.0'
implementation 'com.google.android.gms:play-services-gcm:16.0.0'
 */
class Autenticacion(context:Context):BaseFirebase(context)
{

    enum class CodigosError (val numero:Int){

    }
    init {
        FirebaseApp.initializeApp(context)
    }
    val mAuth =FirebaseAuth.getInstance()

    fun crearCuentaCorreoContrasenia(objeto:Any,
                    respuestaOk : ((Any?)->Unit)? ,
                    validaciones: MutableMap<(Any?)->Boolean,()->Unit>,
                    sinInternet : (()->Unit)?
    ){
        validaciones.forEach {
            if (it.key.invoke(objeto)){
                respuestaFallaAsincrona(it.value)
                return
            }
        }
        val user= mAuth.currentUser
        if(!UsuarioEnvioInvalido(objeto)){
            return
        }

        val tmp = mAuth.createUserWithEmailAndPassword("trigoperfec3@hotmail.com","123456")
        tmp.addOnCompleteListener{
            if(it.isSuccessful){
                respuestaOk?.invoke(null)
                return@addOnCompleteListener
            }
        }

    }

    fun inicioSesionCorreoContrasenia(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    fun inicioSesionTelefono(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    fun inicioSesionGoogle(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    fun inicioSesionGooglePlay(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    fun inicioSesionFacebook(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }
    fun inicioSesionTwiter(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }
    fun inicioGitHub(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    fun inicioSesionDBLocal(
            objeto:Any,
            respuestaOk : ((Any?)->Unit)? ,
            respuestaFalla:(()->Unit)?,
            sinInternet : (()->Unit)?
    ){

    }

    private fun UsuarioEnvioInvalido(objeto: Any?):Boolean{
        if (objeto !is Usuario)                 return false
        if (objeto.correo.isNullOrEmpty())      return false
        if (objeto.contrasenia.isNullOrEmpty()) return false
        return true
    }

}