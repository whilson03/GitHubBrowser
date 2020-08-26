package com.olabode.wilson.githubbrowser.githubapi

import retrofit2.http.GET

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
interface GitHubApi {

    @GET("search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend fun getTopRepositories(): TopRepoSearchResult
}

