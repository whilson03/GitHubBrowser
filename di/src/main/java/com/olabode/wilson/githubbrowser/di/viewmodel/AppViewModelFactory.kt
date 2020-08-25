package com.olabode.wilson.githubbrowser.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */
@Suppress("UNCHECKED_CAST")
class AppViewModelFactory @Inject constructor(
    private val classToViewModel: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return classToViewModel[modelClass]?.get() as? T
            ?: throw  NullPointerException("No viewmodel mapping for class :${modelClass.name}")
    }
}