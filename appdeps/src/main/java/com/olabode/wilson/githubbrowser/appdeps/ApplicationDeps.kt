package com.olabode.wilson.githubbrowser.appdeps

import com.olabode.wilson.githubbrowser.repository.AppRepository

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */
interface ApplicationDeps {

    fun appRepository(): AppRepository

}