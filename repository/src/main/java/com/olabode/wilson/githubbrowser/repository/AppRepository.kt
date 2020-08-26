package com.olabode.wilson.githubbrowser.repository

import com.olabode.wilson.githubbrowser.githubapi.GitHubApi
import com.olabode.wilson.githubbrowser.githubapi.model.ContributorApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
@Singleton
class AppRepository @Inject constructor(
    private val gitHubApi: GitHubApi
) {

    private val cachedRepos = mutableListOf<RepoApiModel>()

    suspend fun getTopRepos(): List<RepoApiModel> {
        if (cachedRepos.isEmpty()) {
            cachedRepos.addAll(gitHubApi.getTopRepositories().items)
        }
        return cachedRepos
    }

    suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        return getRepoFromCache(repoOwner, repoName) ?: gitHubApi.getRepo(repoOwner, repoName)
    }

    suspend fun getContributors(repoOwner: String, repoName: String): List<ContributorApiModel> {
        return gitHubApi.getContributors(repoOwner, repoName)
    }

    private fun getRepoFromCache(repoOwner: String, repoName: String): RepoApiModel? {
        return cachedRepos.firstOrNull { repo ->
            repo.owner.login == repoOwner && repo.name == repoName
        }
    }
}