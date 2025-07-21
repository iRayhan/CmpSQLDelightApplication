package com.example.cmpsqldelightapplication

import android.app.Application
import com.example.cmpsqldelightapplication.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApp)
        }
    }
}