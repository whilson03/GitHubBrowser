package com.olabode.wilson.githubbrowser.githubapi.model

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

data class RepoApiModel(
    val id: Long,
    val name: String,
    val description: String,
    val owner: UserApiModel,
    val stargazersCount: String,
    val forksCount: String,
    val contributorsUrl: String,
    val createdDate: String,
    val updatedDate: String
)