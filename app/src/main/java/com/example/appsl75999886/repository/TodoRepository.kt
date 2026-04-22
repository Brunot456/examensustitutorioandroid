package com.example.appsl75999886.repository

import com.example.appsl75999886.api.RetrofitClient
import com.example.appsl75999886.model.Todo

class TodoRepository {
    suspend fun getTodos(): List<Todo> {
        return try {
            RetrofitClient.apiService.getTodos()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
