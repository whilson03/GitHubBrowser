package com.olabode.wilson.githubbrowser.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.olabode.wilson.githubbrowser.home.databinding.HomeScreenBinding

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}