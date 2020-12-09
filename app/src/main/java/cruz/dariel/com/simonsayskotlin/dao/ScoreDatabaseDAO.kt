package cruz.dariel.com.simonsayskotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import cruz.dariel.com.simonsayskotlin.models.Score

interface ScoreDatabaseDAO {

    @Insert
    fun insert(score: Score)

    @Query("Select * from score_table ORDER BY id DESC")
    suspend fun getAll() : LiveData<List<Score>>

    @Query("SELECT * from score_table WHERE playerName = :name")
    suspend fun search(name: String) : LiveData<List<Score>>

    @Query("SELECT * FROM score_table ORDER BY id DESC LIMIT 1")
    suspend fun getLastScore(): Score?

    @Query("SELECT * FROM score_table ORDER BY score DESC LIMIT 1")
    suspend fun getHighestScore(): LiveData<Score>
}