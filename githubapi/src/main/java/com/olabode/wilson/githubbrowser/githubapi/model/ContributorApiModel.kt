package com.olabode.wilson.githubbrowser.githubapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */

@JsonClass(generateAdapter = true)
data class ContributorApiModel(
    val id: Long,
    val login: String,
    @Json(name = "avatar_url") val avatarUrl: String
)