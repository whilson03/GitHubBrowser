package com.olabode.wilson.githubbrowser.githubapi

import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.squareup.moshi.JsonClass

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */


@JsonClass(generateAdapter = true)
data class TopRepoSearchResult(val items: List<RepoApiModel>)