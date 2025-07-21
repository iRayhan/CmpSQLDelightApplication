package com.example.cmpsqldelightapplication.ui.domain

import kotlinx.coroutines.flow.Flow
import tables.TestTable

interface TodoRepository {
    suspend fun getDummyTodos(): List<String>
    suspend fun createDbTodos(list: List<TestTable>)
    suspend fun addDbTodo(table: TestTable)
    suspend fun getDbTodos(): Flow<List<TestTable>>
}