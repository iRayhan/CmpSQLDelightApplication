package com.example.cmpsqldelightapplication.shared.database.cache

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.cmpsqldelightapplication.core.data.dbFileName
import org.koin.core.context.GlobalContext
import tables.Database

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Database.Schema, context, dbFileName)
    }
}

actual fun getDatabaseDriverFactory(): DatabaseDriverFactory {
    return AndroidDatabaseDriverFactory(GlobalContext.get().get<Context>())
}