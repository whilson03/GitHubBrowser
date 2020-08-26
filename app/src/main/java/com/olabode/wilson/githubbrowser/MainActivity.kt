package com.olabode.wilson.githubbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olabode.wilson.githubbrowser.details.RepoDetailsFragment
import com.olabode.wilson.githubbrowser.home.HomeFragment
import com.olabode.wilson.githubbrowser.navigation.DetailsScreen
import com.olabode.wilson.githubbrowser.navigation.NAVIGATION_DEPS_SERVICE
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var component: MainActivityComponent


    @Inject
    lateinit var screenNavigator: ActivityDrivenScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        component = injectAndGetComponent()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, HomeFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        screenNavigator.handleGoToScreen = { screen ->
            when (screen) {
                is DetailsScreen -> supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.screen_container,
                        RepoDetailsFragment.newInstance(screen.repoOwner, screen.repoName)
                    )
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun onStop() {
        screenNavigator.handleGoToScreen = null
        super.onStop()
    }

    override fun getSystemService(name: String): Any? {
        if (name == NAVIGATION_DEPS_SERVICE) {
            return component
        }
        return super.getSystemService(name)
    }
}