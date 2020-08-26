package com.olabode.wilson.githubbrowser.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olabode.wilson.githubbrowser.di.scope.ScreenScope
import com.olabode.wilson.githubbrowser.home.model.RepoItem
import com.olabode.wilson.githubbrowser.repository.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@ScreenScope
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<HomeViewState>(HomeViewState.HomeViewStateLoading)
    val viewState: LiveData<HomeViewState> = _viewState

    init {
        viewModelScope.launch {
            val topRepos = repository.getTopRepos()
            _viewState.value = HomeViewState.HomeViewStateLoaded(
                repos = topRepos.map {
                    RepoItem(
                        name = it.name,
                        description = it.description ?: "",
                        starsCount = it.stargazersCount,
                        forksCount = it.forksCount
                    )
                }
            )
        }

    }

}