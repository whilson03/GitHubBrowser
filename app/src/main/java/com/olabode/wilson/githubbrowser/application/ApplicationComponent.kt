package com.olabode.wilson.githubbrowser.application

import android.content.Context
import com.olabode.wilson.githubbrowser.githubapi.GitHubApiModule
import com.olabode.wilson.githubbrowser.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent {

    fun appRepository(): AppRepository

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}