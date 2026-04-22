package com.example.appsl75999886.repository

import com.example.appsl75999886.api.RetrofitClient
import com.example.appsl75999886.model.Photo

class PhotoRepository {
    suspend fun getPhotos(): List<Photo> {
        return try {
            val allPhotos = RetrofitClient.apiService.getPhotos()
            // Filtrar solo los que tengan albumId PAR
            allPhotos.filter { it.albumId % 2 == 0 }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
