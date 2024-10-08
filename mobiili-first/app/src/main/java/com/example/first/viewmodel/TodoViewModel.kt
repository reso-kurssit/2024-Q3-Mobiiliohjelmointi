package com.example.first.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first.model.TodoModel
import com.example.first.ui.screens.randomTodos.TodosApi

import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    var todos = mutableStateListOf<TodoModel>()
        private set

    init {
        //todos.add("Test1")
        getTodosList()

    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}