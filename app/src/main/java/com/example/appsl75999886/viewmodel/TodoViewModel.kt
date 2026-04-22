package com.example.appsl75999886.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsl75999886.model.Todo
import com.example.appsl75999886.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: TodoRepository = TodoRepository()) : ViewModel() {

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchTodos() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val todosList = todoRepository.getTodos()
                _todos.value = todosList
            } catch (e: Exception) {
                _error.value = "Error al cargar los todos: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
