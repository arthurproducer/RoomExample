package br.com.fiap.roomexample.di

import androidx.room.Room
import br.com.fiap.roomexample.MainViewModel
import br.com.fiap.roomexample.WordListAdapter
import br.com.fiap.roomexample.dao.WordRoomDatabase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

import br.com.fiap.roomexample.repository.WordRepository

//Injecção de dependencia


val repositoryModule = module {
    single {
        WordRepository(get())
    }
}
val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }
}
val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}

val uiModule = module {
    factory { WordListAdapter(get()) }
}

