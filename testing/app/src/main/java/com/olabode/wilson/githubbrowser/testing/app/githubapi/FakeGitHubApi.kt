package com.olabode.wilson.githubbrowser.testing.app.githubapi

import com.olabode.wilson.githubbrowser.githubapi.GitHubApi
import com.olabode.wilson.githubbrowser.githubapi.TopRepoSearchResult
import com.olabode.wilson.githubbrowser.githubapi.model.ContributorApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@Singleton
class FakeGitHubApi @Inject constructor() : GitHubApi {

    var topRepos = listOf<RepoApiModel>()
    var singleRepoResult: RepoApiModel? = null
    var contributorsResult = listOf<ContributorApiModel>()


    override suspend fun getTopRepositories(): TopRepoSearchResult {
        return TopRepoSearchResult(topRepos)
    }

    override suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        return singleRepoResult ?: throw  NullPointerException("Single Result was not set")
    }

    override suspend fun getContributors(
        repoOwner: String,
        repoName: String
    ): List<ContributorApiModel> {
        return contributorsResult
    }
}