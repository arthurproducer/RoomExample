package br.com.fiap.roomexample

import android.app.Application
import br.com.fiap.roomexample.di.dbModule
import br.com.fiap.roomexample.di.repositoryModule
import br.com.fiap.roomexample.di.uiModule
import br.com.fiap.roomexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.facebook.stetho.Stetho
import org.koin.core.module.Module

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
        }

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(repositoryModule, dbModule, viewModelModule, uiModule)
            )
        }
    }
}