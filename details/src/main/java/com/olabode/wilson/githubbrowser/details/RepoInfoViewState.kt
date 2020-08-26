package com.olabode.wilson.githubbrowser.details

import com.olabode.wilson.githubbrowser.details.adapter.ContributorItem

sealed class RepoInfoViewState
object RepoInfoViewStateLoading : RepoInfoViewState()
data class RepoInfoViewStateLoaded(
    val repoName: String,
    val repoDescription: String,
    val createdDate: String,
    val updatedDate: String
) : RepoInfoViewState()

sealed class RepoContributorsViewState
object RepoContributorsViewStateLoading : RepoContributorsViewState()
data class RepoContributorsViewStateLoaded(val contributors: List<ContributorItem>) :
    RepoContributorsViewState()