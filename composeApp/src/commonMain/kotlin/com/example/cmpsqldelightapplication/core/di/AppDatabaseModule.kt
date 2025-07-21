package com.example.cmpsqldelightapplication.core.di

import com.example.cmpsqldelightapplication.core.data.AppDatabase
import com.example.cmpsqldelightapplication.shared.database.cache.getDatabaseDriverFactory
import org.koin.dsl.module

val appDatabaseModule = module {

    single<AppDatabase> {
        AppDatabase(getDatabaseDriverFactory())
    }

}