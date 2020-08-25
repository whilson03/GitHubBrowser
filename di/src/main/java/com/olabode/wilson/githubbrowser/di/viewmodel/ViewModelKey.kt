package com.olabode.wilson.githubbrowser.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@MapKey
annotation class ViewModelKey(val classKey: KClass<out ViewModel>)