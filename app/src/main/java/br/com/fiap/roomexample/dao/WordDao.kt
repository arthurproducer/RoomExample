package br.com.fiap.roomexample.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fiap.roomexample.model.Word

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>> //Retorna os dados no caso de atualização

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Usado para informar o que deve acontecer com o insert caso não funcione*
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}