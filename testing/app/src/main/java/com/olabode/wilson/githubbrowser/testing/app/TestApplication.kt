package com.olabode.wilson.githubbrowser.testing.app

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.olabode.wilson.githubbrowser.appdeps.ApplicationDeps
import com.olabode.wilson.githubbrowser.appdeps.HasApplicationDeps
import com.olabode.wilson.githubbrowser.navigation.NAVIGATION_DEPS_SERVICE

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */


class TestApplication : Application(), HasApplicationDeps {

    companion object {
        val component: TestApplicationComponent
            get() = (InstrumentationRegistry
                .getInstrumentation()
                .targetContext.applicationContext as TestApplication).component
    }

    private lateinit var component: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerTestApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return component
    }

    override fun getSystemService(name: String): Any {
        if (name == NAVIGATION_DEPS_SERVICE) {
            return component
        }
        return super.getSystemService(name)
    }
}