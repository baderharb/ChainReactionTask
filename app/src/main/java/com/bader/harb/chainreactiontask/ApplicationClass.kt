package com.bader.harb.chainreactiontask

import android.app.Application
import android.content.Context
import com.bader.harb.chainreactiontask.core.component.utils.Languages
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(Languages.setLocale(base))
    }
}