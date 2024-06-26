package com.uam.scheduleapk.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.scheduleapk.repository.RepositoryUsuario
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    private val repository = RepositoryUsuario()

    var state by mutableStateOf(State())
        private set

    fun onEmail(email: String){
        state = state.copy(email = email)
    }

    fun onPassword(password: String){
        state = state.copy(password = password)
    }

    fun onLogin(){
        viewModelScope.launch {
            val result = repository.login(state.email,state.password)
            if (result.isSuccess) {
                state = if (result.getOrNull() == 1) {
                            state.copy(error = false, mensaje = "Usuario conectado")
                        }
                        else {
                            state.copy(error = true, mensaje = "Usuario incorrecto")
                        }
            }
            else {
                state = state.copy(error = true, mensaje = "Error al conectarse al red")
            }
        }
    }


    fun restartState() {
        state = state.copy(error = false, mensaje = null)
    }

    // Todos los valores en un data class
    // son inicializados
    data class State(
        val email : String = "",
        val password : String = "",
        val mensaje : String? = null,
        val error : Boolean = false
    )
}