package com.example.appsl75999886.api

import com.example.appsl75999886.model.Photo
import com.example.appsl75999886.model.Todo
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}
