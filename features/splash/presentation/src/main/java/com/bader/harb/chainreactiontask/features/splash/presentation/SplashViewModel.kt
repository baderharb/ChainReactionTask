package com.bader.harb.chainreactiontask.features.splash.presentation

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.bader.harb.chainreactiontask.core.navigation.Activities
import com.bader.harb.chainreactiontask.features.splash.domain.usecases.NavFromSplashToNextScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navFromSplashToNextScreenUseCase: NavFromSplashToNextScreenUseCase,
) : ViewModel() {

    fun navigateToNextScreen(currentActivity: Activity) {
        navFromSplashToNextScreenUseCase(
            currentActivity,
            Activities.Main,
        )
    }
}