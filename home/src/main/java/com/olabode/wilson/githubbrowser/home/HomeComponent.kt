package com.olabode.wilson.githubbrowser.home

import com.olabode.wilson.githubbrowser.appdeps.ApplicationDeps
import com.olabode.wilson.githubbrowser.appdeps.applicationDeps
import com.olabode.wilson.githubbrowser.di.component.getComponent
import com.olabode.wilson.githubbrowser.di.scope.ScreenScope
import com.olabode.wilson.githubbrowser.navigation.NavigationDeps
import com.olabode.wilson.githubbrowser.navigation.navigationDeps
import dagger.Component

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@ScreenScope
@Component(
    dependencies = [ApplicationDeps::class, NavigationDeps::class],
    modules = [HomeModule::class]
)
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDeps: ApplicationDeps, navigationDeps: NavigationDeps): HomeComponent
    }
}

fun HomeFragment.inject() {
    getComponent {
        DaggerHomeComponent.factory()
            .create(requireContext().applicationDeps(), requireActivity().navigationDeps())
    }.inject(this)
}