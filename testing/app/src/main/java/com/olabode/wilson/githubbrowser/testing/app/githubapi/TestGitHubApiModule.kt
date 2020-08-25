package com.olabode.wilson.githubbrowser.testing.app.githubapi

import com.olabode.wilson.githubbrowser.githubapi.GitHubApi
import dagger.Binds
import dagger.Module

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Module
interface TestGitHubApiModule {

    @Binds
    fun bindGitHubApi(fakeGitHubApi: FakeGitHubApi): GitHubApi
}