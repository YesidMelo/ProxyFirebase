package com.example.elvermelo.template.Repositorios.Firebase

import android.app.Activity
import android.content.Context

open class BaseFirebase(val context: Context) {


    protected  fun sinInternet(sinInternet: (()->Unit)?= null){
       if(context !is Activity){
           sinInternet?.invoke()
           return
       }
        context.runOnUiThread{
            sinInternet?.invoke()
        }
    }

    protected fun respuestaOkAsincrona(respuestaOk: ((Any?)->Unit)?= null,objeto : Any?){
        if(context !is Activity){
            respuestaOk?.invoke(objeto)
            return
        }
        context.runOnUiThread {
            respuestaOk?.invoke(objeto)
        }
    }

    protected fun respuestaFallaAsincrona(respuestaFalla: (()->Unit)?= null){
        if(context !is Activity){
            respuestaFalla?.invoke()
            return
        }
        context.runOnUiThread {
            respuestaFalla?.invoke()
        }
    }

}