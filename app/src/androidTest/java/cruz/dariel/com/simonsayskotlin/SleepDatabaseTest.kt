package cruz.dariel.com.simonsayskotlin

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import cruz.dariel.com.simonsayskotlin.dao.ScoreDatabaseDAO
import cruz.dariel.com.simonsayskotlin.db.SimonSaysDatabase
import cruz.dariel.com.simonsayskotlin.models.Score
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SleepDatabaseTest {

    private lateinit var scoreDao: ScoreDatabaseDAO
    private lateinit var db: SimonSaysDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.databaseBuilder(context, SimonSaysDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        scoreDao = db.scoreDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val night = Score()
        scoreDao.insert(night)
        val last = scoreDao.getLastScore()
        assertEquals(last?.score, -1)
    }
}
