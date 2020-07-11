package cruz.dariel.com.simonsayskotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cruz.dariel.com.simonsayskotlin.dao.ScoreDatabaseDAO
import cruz.dariel.com.simonsayskotlin.models.Score

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class SimonSaysDatabase : RoomDatabase() {

    abstract val scoreDao: ScoreDatabaseDAO

    companion object{
        @Volatile
        private var INSTANCE: SimonSaysDatabase? = null

        fun getInstance(context: Context): SimonSaysDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SimonSaysDatabase::class.java,
                        "simon_says_database"
                    ).
                        fallbackToDestructiveMigration().
                        build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}