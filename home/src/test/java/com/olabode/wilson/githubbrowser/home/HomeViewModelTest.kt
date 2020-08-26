package com.olabode.wilson.githubbrowser.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.UserApiModel
import com.olabode.wilson.githubbrowser.home.model.RepoItem
import com.olabode.wilson.githubbrowser.repository.AppRepository
import com.olabode.wilson.githubbrowser.testing.app.githubapi.FakeGitHubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by OLABODE WILSON on 8/25/20.
 */
class HomeViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var viewStateValues: MutableList<HomeViewState>

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        val appRepository = AppRepository(FakeGitHubApi().apply {
            repos = listOf(fakeRepoApiModel)
        })
        viewModel = HomeViewModel(appRepository)
        viewStateValues = mutableListOf()
        viewModel.viewState.observeForever {
            viewStateValues.add(it)
        }
    }

    @Test
    fun `loaded state contains repo models`() {
        assertThat(viewStateValues.size).isEqualTo(1)
        val expectedState = HomeViewState.HomeViewStateLoaded(
            listOf(
                RepoItem(
                    name = fakeRepoApiModel.name,
                    description = fakeRepoApiModel.description ?: "",
                    starsCount = fakeRepoApiModel.stargazersCount,
                    forksCount = fakeRepoApiModel.forksCount
                )
            )
        )

        assertThat(viewStateValues[0]).isEqualTo(expectedState)
    }
}


private val fakeRepoApiModel = RepoApiModel(
    id = 1L,
    name = "Android Cli",
    description = "A good framework",
    owner = UserApiModel(1L, login = "whilson"),
    stargazersCount = 50,
    forksCount = 4,
    contributorsUrl = "www.",
    createdDate = "1/3/2020",
    updatedDate = "1/3/2020"
)