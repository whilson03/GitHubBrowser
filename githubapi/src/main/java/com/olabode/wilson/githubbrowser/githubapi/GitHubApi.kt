package com.olabode.wilson.githubbrowser.githubapi

import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.UserApiModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
interface GitHubApi {

    fun getTopRepositories(): List<RepoApiModel>
}

@Singleton
class MockGitHubApi @Inject constructor() : GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(
            RepoApiModel(
                id = 1L,
                name = "Android Cli",
                description = "A good framework",
                owner = UserApiModel(1L, login = "whilson"),
                stargazersCount = 50,
                forksCount = 4,
                contributorsUrl = "www.",
                createdDate = "1/3/2020",
                updatedDate = "1/3/2020"
            )
        )
    }
}