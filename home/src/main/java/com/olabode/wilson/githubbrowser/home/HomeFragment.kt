package com.olabode.wilson.githubbrowser.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.olabode.wilson.githubbrowser.di.viewmodel.AppViewModelFactory
import com.olabode.wilson.githubbrowser.home.databinding.HomeScreenBinding
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, appViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}