package com.olabode.wilson.githubbrowser.application

import android.app.Application
import com.olabode.wilson.githubbrowser.appdeps.ApplicationDeps
import com.olabode.wilson.githubbrowser.appdeps.HasApplicationDeps

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
class GitHubBrowserApp : Application(), HasApplicationDeps {

    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)

    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}