package com.olabode.wilson.githubbrowser.appdeps

import android.content.Context

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */
interface HasApplicationDeps {

    fun getApplicationDeps(): ApplicationDeps
}

fun Context.applicationDeps(): ApplicationDeps {
    return (applicationContext as? HasApplicationDeps)?.getApplicationDeps()
        ?: throw IllegalArgumentException("Application Must Implement HasApplicationDeps")
}