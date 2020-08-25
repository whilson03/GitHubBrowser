package com.olabode.wilson.githubbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olabode.wilson.githubbrowser.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, HomeFragment())
                .commit()
        }
    }
}