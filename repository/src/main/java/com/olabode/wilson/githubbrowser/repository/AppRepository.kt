package com.olabode.wilson.githubbrowser.repository

import com.olabode.wilson.githubbrowser.githubapi.GitHubApi
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
   suspend fun getTopRepos(): List<RepoApiModel> {
       return gitHubApi.getTopRepositories().items
   }
}