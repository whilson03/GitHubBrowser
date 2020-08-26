package com.olabode.wilson.githubbrowser.details

import androidx.lifecycle.ViewModel
import com.olabode.wilson.githubbrowser.di.scope.ScreenScope
import com.olabode.wilson.githubbrowser.repository.AppRepository
import javax.inject.Inject
import javax.inject.Named

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */

@ScreenScope
class RepoDetailsViewModel @Inject constructor(
    @Named("repo_owner") val repoOwner: String,
    @Named("repo_name") val repoName: String,
    private val appRepository: AppRepository
) : ViewModel()