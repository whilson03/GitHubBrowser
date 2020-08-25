package com.olabode.wilson.githubbrowser.home

import androidx.lifecycle.ViewModel
import com.olabode.wilson.githubbrowser.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Module
interface HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel): ViewModel
}