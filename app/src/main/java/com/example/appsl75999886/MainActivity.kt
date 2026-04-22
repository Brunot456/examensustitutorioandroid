package com.example.appsl75999886

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.example.appsl75999886.database.AppDatabase
import com.example.appsl75999886.model.Patient
import com.example.appsl75999886.repository.AuthRepository
import com.example.appsl75999886.ui.screen.HomeScreen
import com.example.appsl75999886.ui.screen.LoginScreen
import com.example.appsl75999886.ui.theme.AppSl75999886Theme
import com.example.appsl75999886.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val samplePatients = listOf(
            Patient("PAC001", "pass123", "Juan Garcia", "987654321"),
            Patient("PAC002", "pass456", "Maria Lopez", "987654322"),
            Patient("PAC003", "pass789", "Carlos Rodriguez", "987654323")
        )

        val database = AppDatabase.getDatabase(this)
        val patientDao = database.patientDao()
        val authRepository = AuthRepository(patientDao, samplePatients)

        authViewModel = ViewModelProvider(this, AuthViewModelFactory(authRepository))
            .get(AuthViewModel::class.java)

        setContent {
            AppSl75999886Theme {
                Surface {
                    AppContent(authViewModel)
                }
            }
        }
    }
}

@Composable
fun AppContent(authViewModel: AuthViewModel) {
    val currentPatient by authViewModel.currentPatient.collectAsState()

    if (currentPatient != null) {
        HomeScreen(
            authViewModel = authViewModel,
            onLogout = {}
        )
    } else {
        LoginScreen(
            authViewModel = authViewModel,
            onLoginSuccess = {}
        )
    }
}

class AuthViewModelFactory(private val authRepository: AuthRepository) :
    ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
