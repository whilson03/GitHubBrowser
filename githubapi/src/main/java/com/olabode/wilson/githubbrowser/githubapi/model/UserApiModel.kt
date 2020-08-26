package com.olabode.wilson.githubbrowser.githubapi.model

import com.squareup.moshi.JsonClass

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@JsonClass(generateAdapter = true)
data class UserApiModel(val id: Long, val login: String)