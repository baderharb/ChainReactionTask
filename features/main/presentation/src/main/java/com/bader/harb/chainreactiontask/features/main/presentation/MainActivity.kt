package com.bader.harb.chainreactiontask.features.main.presentation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bader.harb.chainreactiontask.core.component.annotations.ShowBottomBarNavController
import com.bader.harb.chainreactiontask.core.component.utils.Languages
import com.bader.harb.chainreactiontask.core.storage.preferences.Prefs
import com.bader.harb.chainreactiontask.features.main.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var prefs: Prefs
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navHostFragment by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment_activity_main_navigation) as NavHostFragment)
    }
    private val navController by lazy { navHostFragment.navController }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(Languages.setLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initDestinationChangedListener()
    }

    private fun initDestinationChangedListener() {
        binding.bottomNavigationActivityMain.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination is FragmentNavigator.Destination) {
                val hideNavController = Class.forName(destination.className)
                    .getAnnotation(ShowBottomBarNavController::class.java)
                binding.bottomNavigationActivityMain.isVisible = hideNavController != null
            }
        }
    }

    private fun init() {
        checkIfUserLoggedIn()
    }

    private fun checkIfUserLoggedIn() {
        if (!prefs.isLoggedIn) {
            val navOptions: NavOptions = NavOptions.Builder().setPopUpTo(null, true).build()
            navController.navigate(
                com.bader.harb.chainreactiontask.core.navigation.R.id.navigation_fragment_login,
                null,
                navOptions
            )
        }
    }
}