package com.olabode.wilson.githubbrowser.githubapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@JsonClass(generateAdapter = true)
data class RepoApiModel(
    val id: Long,
    val name: String,
    val description: String?,
    val owner: UserApiModel,
    @Json(name = "stargazers_count") val stargazersCount: Int,
    @Json(name = "forks_count") val forksCount: Int,
    @Json(name = "contributors_url") val contributorsUrl: String,
    @Json(name = "created_at") val createdDate: String,
    @Json(name = "updated_at") val updatedDate: String
)