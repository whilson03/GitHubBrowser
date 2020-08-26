package com.olabode.wilson.githubbrowser.details

import androidx.lifecycle.ViewModel
import com.olabode.wilson.githubbrowser.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */

@Module
interface RepoDetailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoDetailsViewModel::class)
    fun bindRepoDetailsViewModel(repoDetailsViewModel: RepoDetailsViewModel): ViewModel
}