package com.olabode.wilson.githubbrowser.testing.app.navigation

import com.olabode.wilson.githubbrowser.navigation.ScreenNavigator
import dagger.Binds
import dagger.Module

@Module
interface TestNavigationModule {

    @Binds
    fun bindScreenNavigator(fakeScreenNavigator: FakeScreenNavigator): ScreenNavigator
}