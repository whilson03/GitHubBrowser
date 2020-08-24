package com.olabode.wilson.githubbrowser.application

import android.app.Application

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
class GitHubBrowserApp : Application() {

    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)

    }
}