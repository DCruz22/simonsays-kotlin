package cruz.dariel.com.simonsayskotlin.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id: Int, val playerName: String, val score: Int, val date: String)