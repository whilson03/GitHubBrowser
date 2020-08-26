package com.olabode.wilson.githubbrowser.testing.app.navigation

import com.olabode.wilson.githubbrowser.navigation.Screen
import com.olabode.wilson.githubbrowser.navigation.ScreenNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeScreenNavigator @Inject constructor() : ScreenNavigator {

    val openedScreens = mutableListOf<Screen>()

    override fun goToScreen(screen: Screen) {
        openedScreens.add(screen)
    }
}