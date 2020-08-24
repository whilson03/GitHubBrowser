package com.olabode.wilson.githubbrowser.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}