package com.olabode.wilson.githubbrowser.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olabode.wilson.githubbrowser.details.adapter.ContributorItem
import com.olabode.wilson.githubbrowser.di.scope.ScreenScope
import com.olabode.wilson.githubbrowser.repository.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */

@ScreenScope
class RepoDetailsViewModel @Inject constructor(
    @Named("repo_owner") val repoOwner: String,
    @Named("repo_name") val repoName: String,
    private val appRepository: AppRepository
) : ViewModel() {
    private val repoInfoViewState = MutableLiveData<RepoInfoViewState>(RepoInfoViewStateLoading)
    val repoInfoUpdates: LiveData<RepoInfoViewState> = repoInfoViewState

    private val contributorsViewState =
        MutableLiveData<RepoContributorsViewState>(RepoContributorsViewStateLoading)
    val contributorsUpdates: LiveData<RepoContributorsViewState> = contributorsViewState

    init {
        viewModelScope.launch {
            val repo = appRepository.getRepo(repoOwner, repoName)
            repoInfoViewState.value = RepoInfoViewStateLoaded(
                repoName = repo.name,
                repoDescription = repo.description ?: "",
                createdDate = repo.createdDate,
                updatedDate = repo.updatedDate
            )
        }
        viewModelScope.launch {
            val contributors = appRepository.getContributors(repoOwner, repoName)
            contributorsViewState.value = RepoContributorsViewStateLoaded(
                contributors = contributors.map { apiModel ->
                    ContributorItem(
                        id = apiModel.id,
                        name = apiModel.login,
                        avatarUrl = apiModel.avatarUrl
                    )
                }
            )
        }
    }
}