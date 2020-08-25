package com.olabode.wilson.githubbrowser.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.olabode.wilson.githubbrowser.home.model.RepoItem
import com.olabode.wilson.githubbrowser.repository.AppRepository
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<HomeViewState>(HomeViewState.HomeViewStateLoading)
    val viewState: LiveData<HomeViewState> = _viewState

    init {
        val topRepos = repository.getTopRepos()
        _viewState.value = HomeViewState.HomeViewStateLoaded(
            repos = topRepos.map {
                RepoItem(
                    name = it.name,
                    description = it.description,
                    starsCount = it.stargazersCount,
                    forksCount = it.forksCount
                )
            }
        )
    }

}