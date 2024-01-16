package com.bader.harb.chainreactiontask.features.splash.domain.usecases

import android.app.Activity
import android.content.Intent
import com.bader.harb.chainreactiontask.core.navigation.AddressableActivity
import com.bader.harb.chainreactiontask.core.navigation.intentTo
import javax.inject.Inject

class NavFromSplashToNextScreenUseCase @Inject constructor() {

    operator fun invoke(currentActivity: Activity, addressableActivity: AddressableActivity) {
        val mainIntent = currentActivity.intentTo(addressableActivity)
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        currentActivity.finish()
        currentActivity.startActivity(mainIntent)
    }
}