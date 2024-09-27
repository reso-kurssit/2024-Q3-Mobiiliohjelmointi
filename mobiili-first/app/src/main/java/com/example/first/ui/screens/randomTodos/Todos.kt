package com.example.first.ui.screens.randomTodos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.first.model.TodoModel
import com.example.first.viewmodel.TodoViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<TodoModel>

    companion object {
        var todosService: TodosApi? = null

        fun getInstance(): TodosApi {
            if (todosService === null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosService!!
        }
    }
}

@Composable
fun TodoScreen(navController: NavController, todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos)

}

@Composable
fun TodoList(todos: List<TodoModel>) {

    val textStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )

    val dividerColor = MaterialTheme.colorScheme.onSecondaryContainer

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(todos) { todo ->

            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                style = textStyle
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = dividerColor
            )

        }
    }
}