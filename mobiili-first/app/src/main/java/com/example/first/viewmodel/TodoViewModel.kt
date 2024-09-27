package com.example.first.viewmodel

import androidx.lifecycle.ViewModel
import com.example.first.model.TodoModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel : ViewModel() {
    val todos = mutableListOf<String>()

    init {
        TodoModel(1, "Buy groceries")
        TodoModel(2, "Walk the dog")
        TodoModel(3, "Finish homework")

        todos.add("Test1")
        todos.add("Test2")
        todos.add("Test3")
    }
}