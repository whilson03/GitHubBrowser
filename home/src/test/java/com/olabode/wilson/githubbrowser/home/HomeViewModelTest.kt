package com.olabode.wilson.githubbrowser.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.UserApiModel
import com.olabode.wilson.githubbrowser.home.model.RepoItem
import com.olabode.wilson.githubbrowser.navigation.DetailsScreen
import com.olabode.wilson.githubbrowser.repository.AppRepository
import com.olabode.wilson.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.olabode.wilson.githubbrowser.testing.app.navigation.FakeScreenNavigator
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
    private lateinit var screenNavigator: FakeScreenNavigator

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        val appRepository = AppRepository(FakeGitHubApi().apply {
            topRepos = listOf(fakeRepoApiModel)
        })
        screenNavigator = FakeScreenNavigator()
        viewModel = HomeViewModel(appRepository, screenNavigator)
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
                    forksCount = fakeRepoApiModel.forksCount,
                    ownerName = fakeRepoApiModel.owner.login
                )
            )
        )

        assertThat(viewStateValues[0]).isEqualTo(expectedState)
    }


    @Test
    fun `repoSelected calls goToScreen`() {
        viewModel.onRepoSelected(fakeRepoApiModel.owner.login, fakeRepoApiModel.name)

        val expectedScreen = DetailsScreen(fakeRepoApiModel.owner.login, fakeRepoApiModel.name)

        assertThat(screenNavigator.openedScreens.size).isEqualTo(1)
        assertThat(screenNavigator.openedScreens[0]).isEqualTo(expectedScreen)
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