package com.olabode.wilson.githubbrowser.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.olabode.wilson.githubbrowser.githubapi.model.RepoApiModel
import com.olabode.wilson.githubbrowser.githubapi.model.UserApiModel
import com.olabode.wilson.githubbrowser.testing.app.TestApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setUp() {
        val gitHubApi = TestApplication.component.gitHubApi()
        gitHubApi.repos = listOf(
            RepoApiModel(
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
        )
    }


    @Test
    fun reposDisplayed() {
        launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.repo_name)).check(matches(withText("Android Cli")))
    }
}