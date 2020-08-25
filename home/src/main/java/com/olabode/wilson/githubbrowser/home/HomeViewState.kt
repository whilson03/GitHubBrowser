package com.olabode.wilson.githubbrowser.home

import com.olabode.wilson.githubbrowser.home.model.RepoItem

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */
sealed class HomeViewState {

    object HomeViewStateLoading : HomeViewState()
    data class HomeViewStateLoaded(val repos: List<RepoItem>) : HomeViewState()
    data class HomeViewStateError(val message: String) : HomeViewState()

}