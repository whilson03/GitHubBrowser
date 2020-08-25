package com.olabode.wilson.githubbrowser.appcomponent

import android.content.Context
import com.olabode.wilson.githubbrowser.appdeps.ApplicationDeps
import com.olabode.wilson.githubbrowser.githubapi.GitHubApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent : ApplicationDeps {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}