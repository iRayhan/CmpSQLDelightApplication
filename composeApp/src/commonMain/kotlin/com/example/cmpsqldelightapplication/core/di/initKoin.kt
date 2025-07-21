package com.example.cmpsqldelightapplication.core.di

import com.example.cmpsqldelightapplication.ui.di.todoModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appDatabaseModule,
            todoModule,
        )
    }
}