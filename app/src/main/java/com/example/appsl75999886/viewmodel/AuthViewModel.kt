package com.example.appsl75999886.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsl75999886.model.Patient
import com.example.appsl75999886.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _currentPatient = MutableStateFlow<Patient?>(null)
    val currentPatient: StateFlow<Patient?> = _currentPatient

    fun login(codpaciente: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val patient = authRepository.loginPatient(codpaciente, password)
                if (patient != null) {
                    _currentPatient.value = patient
                    _loginState.value = LoginState.Success
                } else {
                    _currentPatient.value = null
                    _loginState.value = LoginState.Error("Codigo de paciente o password incorrectos")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Error al iniciar sesion: ${e.message}")
            }
        }
    }

    fun logout() {
        _currentPatient.value = null
        _loginState.value = LoginState.Idle
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}
