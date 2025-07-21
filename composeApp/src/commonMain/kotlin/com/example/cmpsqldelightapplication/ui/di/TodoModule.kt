package com.example.cmpsqldelightapplication.ui.di

import com.example.cmpsqldelightapplication.core.data.AppDatabase
import com.example.cmpsqldelightapplication.ui.data.TodoRepositoryImpl
import com.example.cmpsqldelightapplication.ui.data.database.TodoDatabase
import com.example.cmpsqldelightapplication.ui.domain.TodoRepository
import com.example.cmpsqldelightapplication.ui.presentation.TodoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val todoModule = module {

    single<TodoDatabase> {
        TodoDatabase(get<AppDatabase>().database.testTableQueries)
    }

    single<TodoRepository> {
        TodoRepositoryImpl(get())
    }

    viewModel<TodoViewModel> {
        TodoViewModel(get())
    }
}