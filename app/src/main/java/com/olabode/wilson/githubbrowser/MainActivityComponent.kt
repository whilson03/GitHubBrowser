package com.olabode.wilson.githubbrowser

import com.olabode.wilson.githubbrowser.di.component.getComponent
import com.olabode.wilson.githubbrowser.di.scope.ActivityScope
import com.olabode.wilson.githubbrowser.navigation.NavigationDeps
import com.olabode.wilson.githubbrowser.navigation.ScreenNavigator
import dagger.Binds
import dagger.Component
import dagger.Module

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent : NavigationDeps {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    @Binds
    fun bindScreenNavigator(activityDrivenScreenNavigator: ActivityDrivenScreenNavigator): ScreenNavigator
}

fun MainActivity.injectAndGetComponent(): MainActivityComponent {
    val component = getComponent { DaggerMainActivityComponent.create() }
    component.inject(this)
    return component
}