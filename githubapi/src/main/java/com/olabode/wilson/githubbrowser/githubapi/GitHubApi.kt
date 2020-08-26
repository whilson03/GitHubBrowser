package com.olabode.wilson.githubbrowser.githubapi

import com.olabode.wilson.githubbrowser.githubapi.model.ContributorApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
interface GitHubApi {

    @GET("search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend fun getTopRepositories(): TopRepoSearchResult

    @GET("repos/{owner}/{name}")
    suspend fun getRepo(
        @Path("owner") repoOwner: String,
        @Path("name") repoName: String
    ): RepoApiModel

    @GET("repos/{owner}/{name}/contributors")
    suspend fun getContributors(
        @Path("owner") repoOwner: String,
        @Path("name") repoName: String
    ): List<ContributorApiModel>


}

