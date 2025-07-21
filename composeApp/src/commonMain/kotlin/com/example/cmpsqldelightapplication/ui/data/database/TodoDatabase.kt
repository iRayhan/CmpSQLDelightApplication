package com.example.cmpsqldelightapplication.ui.data.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import tables.TestTable
import tables.TestTableQueries

class TodoDatabase(
    private val dbQuery: TestTableQueries,
) {
    internal fun clearAndCreateTestTable(list: List<TestTable>) {
        dbQuery.transaction {
            dbQuery.removeAllTestTable()
            list.forEach { table ->
                dbQuery.insertTestTable(table.id, table.name, table.note, table.date, table.time)
            }
        }
    }

    internal fun addTestTable(table: TestTable) {
        dbQuery.insertTestTable(table.id, table.name, table.note, table.date, table.time)
    }

    internal fun getAllTestTable(): Flow<List<TestTable>> {
        return dbQuery.selectAllTestTableInfo().asFlow().mapToList(Dispatchers.IO)
    }
}