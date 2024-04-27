package com.example.todolist.app

import android.app.Application
import com.example.todolist.di.appModule
import com.example.todolist.di.dataModule
import com.example.todolist.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

import org.koin.core.context.startKoin
//import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{

            androidLogger(Level.ERROR) //TODO в DEBUG не работает
            androidContext(this@App)
            modules(listOf(appModule, dataModule ,domainModule))
        }
    }

}