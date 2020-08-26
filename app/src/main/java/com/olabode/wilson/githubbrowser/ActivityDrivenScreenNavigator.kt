package com.olabode.wilson.githubbrowser

import com.olabode.wilson.githubbrowser.di.scope.ActivityScope
import com.olabode.wilson.githubbrowser.navigation.Screen
import com.olabode.wilson.githubbrowser.navigation.ScreenNavigator
import javax.inject.Inject

@ActivityScope
class ActivityDrivenScreenNavigator @Inject constructor() : ScreenNavigator {

    var handleGoToScreen: ((Screen) -> Unit)? = null

    override fun goToScreen(screen: Screen) {
        handleGoToScreen?.invoke(screen)
    }
}