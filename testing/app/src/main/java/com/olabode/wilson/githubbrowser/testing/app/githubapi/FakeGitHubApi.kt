package com.olabode.wilson.githubbrowser.testing.app.githubapi

import com.olabode.wilson.githubbrowser.githubapi.GitHubApi
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Singleton
class FakeGitHubApi @Inject constructor() : GitHubApi {
    val repos = listOf<RepoApiModel>()

    override fun getTopRepositories(): List<RepoApiModel> {
        return repos
    }
}