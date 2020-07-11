package cruz.dariel.com.simonsayskotlin.dao

import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import cruz.dariel.com.simonsayskotlin.models.Score

interface ScoreDatabaseDAO {

    @Insert
    fun insert(score: Score)

    @Query("Select * from score_table ORDER BY id DESC")
    fun getAll() : LiveData<List<Score>>

    @Query("SELECT * from score_table WHERE playerName = :name")
    fun search(name: String) : LiveData<List<Score>>
}