package cruz.dariel.com.simonsayskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import cruz.dariel.com.simonsayskotlin.R
import cruz.dariel.com.simonsayskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myNavHostFragment by lazy {
        this.findNavController(R.id.myNavHostFragment)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        appBarConfiguration = AppBarConfiguration(myNavHostFragment.graph)
        NavigationUI.setupActionBarWithNavController(this, myNavHostFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(myNavHostFragment, appBarConfiguration)
    }
}
