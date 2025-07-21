package com.example.cmpsqldelightapplication.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cmpsqldelightapplication.ui.domain.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tables.TestTable

class TodoViewModel(
    private val repository: TodoRepository,
) : ViewModel() {

    private val _stateTodo = MutableStateFlow(emptyList<TestTable>())
    val stateTodo = _stateTodo.asStateFlow()

    fun addTestTable(table: TestTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.addDbTodo(table)
    }

    suspend fun getAllTestTable(): Flow<List<TestTable>> {
        return repository.getDbTodos()
    }

    init {
        viewModelScope.launch {
            getAllTestTable()
                .onEach { dbTables ->
                    _stateTodo.update {
                        dbTables
                    }
                }.stateIn(viewModelScope)
        }
    }
}