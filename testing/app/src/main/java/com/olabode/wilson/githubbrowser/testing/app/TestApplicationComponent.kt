package com.olabode.wilson.githubbrowser.testing.app

import android.content.Context
import com.olabode.wilson.githubbrowser.appcomponent.ApplicationComponent
import com.olabode.wilson.githubbrowser.navigation.NavigationDeps
import com.olabode.wilson.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.olabode.wilson.githubbrowser.testing.app.githubapi.TestGitHubApiModule
import com.olabode.wilson.githubbrowser.testing.app.navigation.TestNavigationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Singleton
@Component(modules = [TestGitHubApiModule::class, TestNavigationModule::class])
interface TestApplicationComponent : ApplicationComponent, NavigationDeps {

    fun gitHubApi(): FakeGitHubApi

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): TestApplicationComponent
    }
}