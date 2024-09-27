package com.example.first.ui.screens.randomTodos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.first.viewmodel.TodoViewModel


@Composable
fun TodoScreen(navController: NavController, todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos)

}

@Composable
fun TodoList(todos: MutableList<String>) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(todos) { todo ->

            Text(
                text = todo,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                color = Color.Red
            )
            HorizontalDivider(color = Color.Red, thickness = 1.dp)

        }
    }
}
