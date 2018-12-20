package com.example.elvermelo.template.Repositorios.Firebase.Modelos

class Usuario {
    var correo      :String ?= null
    var contrasenia :String ?= null

    enum class MetodosEnvio{
        CORREO_VACIO,
        CORREO_VALIDO,
        CONTRASENA_VACIA,
        CONTRASENIA_VALIDO,
        ES_USUARIO_FIREBASE,
    }

    enum class MetodosFallaAutenticacion{
        USUARIO_REGISTRADO,
        CORREO_NO_REGISTRADO,
        CONTRASENIA_INCORRECTA,
    }

    open class ValidacionesEnvio{

        fun generadorMapaValidaciones(
                mapaValidacionesEnvio:MutableMap<MetodosEnvio,()->Unit>,
                fallaUsuarioFirebase:()->Unit
                ):MutableMap<(Any?)->Boolean,()->Unit>{
            val mapaFunciones = emptyMap<(Any?)->Boolean,()->Unit>().toMutableMap()
            mapaFunciones.put(::usuarioInvalido,fallaUsuarioFirebase)
            mapaValidacionesEnvio.forEach {
                when(it.key){
                    MetodosEnvio.CORREO_VACIO-> mapaFunciones.put(::CorreoVacioInvalido,it.value)
                    MetodosEnvio.CONTRASENA_VACIA -> mapaFunciones.put(::ContraseniaVaciaInvalido,it.value)
                    MetodosEnvio.CORREO_VALIDO -> mapaFunciones.put(::CorreoValidoInvalido,it.value)
                    MetodosEnvio.CONTRASENIA_VALIDO -> mapaFunciones.put(::ContraseniaValidaInvalido,it.value)
                }
            }
            return mapaFunciones
        }


        private fun usuarioInvalido(objeto: Any?):Boolean{
            if(objeto !is Usuario){
                return true
            }
            return false
        }
        private fun CorreoVacioInvalido(objeto : Any?):Boolean{
            if(objeto !is Usuario){
                return true
            }
            if(objeto.correo.isNullOrEmpty()){
                return true
            }
            return false
        }
        private fun CorreoValidoInvalido(objeto : Any?):Boolean{
            if(objeto !is Usuario){
                return true
            }
            if(objeto.correo.isNullOrEmpty()){
                return true
            }
            return false
        }
        private fun ContraseniaVaciaInvalido(objeto : Any?):Boolean{
            if(objeto !is Usuario){
                return true
            }
            if(objeto.contrasenia.isNullOrEmpty()){
                return true
            }
            return false
        }
        private fun ContraseniaValidaInvalido(objeto : Any?):Boolean{
            if(objeto !is Usuario){
                return true
            }
            if(objeto.contrasenia.isNullOrEmpty()){
                return true
            }
            return false
        }
    }

}