package com.example.cmpsqldelightapplication.ui.data

import com.example.cmpsqldelightapplication.ui.data.database.TodoDatabase
import com.example.cmpsqldelightapplication.ui.domain.TodoRepository
import kotlinx.coroutines.flow.Flow
import tables.TestTable

class TodoRepositoryImpl(
    private val database: TodoDatabase,
) : TodoRepository {
    override suspend fun getDummyTodos(): List<String> {
        return (1..10).map {
            "Todo $it"
        }
    }

    override suspend fun createDbTodos(list: List<TestTable>) {
        database.clearAndCreateTestTable(list)
    }

    override suspend fun addDbTodo(table: TestTable) {
        database.addTestTable(table)
    }

    override suspend fun getDbTodos(): Flow<List<TestTable>> {
        return database.getAllTestTable()
    }

}