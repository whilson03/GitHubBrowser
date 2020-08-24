package com.olabode.wilson.githubbrowser.githubapi

import dagger.Binds
import dagger.Module

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@Module
interface GitHubApiModule {

    @Binds
    fun bindGitHubApi(mockGitHubApi: MockGitHubApi): GitHubApi
}