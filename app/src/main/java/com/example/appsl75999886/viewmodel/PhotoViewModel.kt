package com.example.appsl75999886.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsl75999886.model.Photo
import com.example.appsl75999886.repository.PhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotoViewModel(private val photoRepository: PhotoRepository = PhotoRepository()) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photos: StateFlow<List<Photo>> = _photos

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchPhotos() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val photosList = photoRepository.getPhotos()
                _photos.value = photosList
            } catch (e: Exception) {
                _error.value = "Error al cargar las fotos: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
