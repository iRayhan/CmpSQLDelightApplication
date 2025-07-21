package com.example.cmpsqldelightapplication.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import tables.TestTable
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoViewModel = koinViewModel(),
) {
    val todos by viewModel.stateTodo.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn {
            items(todos) { todos ->
                Text(
                    text = "${todos.name}, ${todos.note}, ${todos.date}, ${todos.time}",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
            }
        }

        Button(
            content = {
                Text("Add More")
            },
            onClick = {
                viewModel.addTestTable(
                    TestTable(todos.size.toLong(), "${todos.size.toLong()}", "${todos.size.toLong()} note", "2/8/5", "time ${todos.size}")
                )
            }
        )
    }
}