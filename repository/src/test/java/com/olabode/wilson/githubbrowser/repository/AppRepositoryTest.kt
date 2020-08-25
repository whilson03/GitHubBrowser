package com.olabode.wilson.githubbrowser.repository


import com.google.common.truth.Truth.assertThat
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.UserApiModel
import com.olabode.wilson.githubbrowser.testing.app.githubapi.FakeGitHubApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

class AppRepositoryTest {

    private lateinit var appRepository: AppRepository
    private val fakeGitHubApi = FakeGitHubApi().apply {
        repos = listOf(fakeRepoApiModel)
    }

    @Before
    fun setUp() {
        appRepository = AppRepository(fakeGitHubApi)
    }

    @Test
    fun successfulQuery() {
        val topRepos = runBlocking { appRepository.getTopRepos() }
        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)
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