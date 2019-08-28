package br.com.fiap.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.fiap.roomexample.dao.WordRoomDatabase
import br.com.fiap.roomexample.model.Word
import br.com.fiap.roomexample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//PRECISA DE CONTEXTO ANDROIDVIEWMODEL  não precisa VIEWMODEL

class MainViewModel(application: Application,
                    private val wordRepository: WordRepository) : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>> = wordRepository.allWords

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordRepository.insert(word)
    }
}