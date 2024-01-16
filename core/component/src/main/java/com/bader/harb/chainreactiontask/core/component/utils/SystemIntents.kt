package com.bader.harb.chainreactiontask.core.component.utils

import android.content.Intent
import androidx.fragment.app.Fragment

fun Fragment.shareContent(link: String, title: String) {
    try {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
        shareIntent.putExtra(Intent.EXTRA_TEXT, link)
        startActivity(Intent.createChooser(shareIntent, "Share: $title"))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}