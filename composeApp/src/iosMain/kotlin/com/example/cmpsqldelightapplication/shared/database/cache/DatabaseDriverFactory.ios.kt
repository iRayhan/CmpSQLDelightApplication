package com.example.cmpsqldelightapplication.shared.database.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.cmpsqldelightapplication.core.data.dbFileName
import tables.Database

class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, dbFileName)
    }
}

actual fun getDatabaseDriverFactory(): DatabaseDriverFactory {
    return IOSDatabaseDriverFactory()
}