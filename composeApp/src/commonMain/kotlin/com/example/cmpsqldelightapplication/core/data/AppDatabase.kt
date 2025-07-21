package com.example.cmpsqldelightapplication.core.data

import com.example.cmpsqldelightapplication.shared.database.cache.DatabaseDriverFactory
import tables.Database

internal val dbFileName = "app_database.tables"

class AppDatabase(databaseDriverFactory: DatabaseDriverFactory) {
    val database = Database(databaseDriverFactory.createDriver())
}