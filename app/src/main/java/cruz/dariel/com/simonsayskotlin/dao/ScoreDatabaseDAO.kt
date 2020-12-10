package cruz.dariel.com.simonsayskotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cruz.dariel.com.simonsayskotlin.models.Score

@Dao
interface ScoreDatabaseDAO {

    @Insert
    suspend fun insert(score: Score)

    @Query("Select * from score_table ORDER BY id DESC")
    fun getAll() : LiveData<List<Score>>

    @Query("SELECT * from score_table WHERE playerName = :name")
    fun search(name: String) : LiveData<List<Score>>

    @Query("SELECT * FROM score_table ORDER BY id DESC LIMIT 1")
    fun getLastScore(): LiveData<Score?>

    @Query("SELECT * FROM score_table ORDER BY score DESC LIMIT 1")
    fun getHighestScore(): LiveData<Score?>
}