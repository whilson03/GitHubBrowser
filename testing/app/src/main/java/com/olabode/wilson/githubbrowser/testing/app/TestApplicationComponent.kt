package com.olabode.wilson.githubbrowser.testing.app

import android.content.Context
import com.olabode.wilson.githubbrowser.appcomponent.ApplicationComponent
import com.olabode.wilson.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.olabode.wilson.githubbrowser.testing.app.githubapi.TestGitHubApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Singleton
@Component(modules = [TestGitHubApiModule::class])
interface TestApplicationComponent : ApplicationComponent {

    fun gitHubApi(): FakeGitHubApi

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): TestApplicationComponent
    }
}