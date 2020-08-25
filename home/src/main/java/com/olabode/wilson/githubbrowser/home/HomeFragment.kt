package com.olabode.wilson.githubbrowser.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.olabode.wilson.githubbrowser.di.viewmodel.AppViewModelFactory
import com.olabode.wilson.githubbrowser.home.HomeViewState.*
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

        binding.repoList.apply {
            adapter = HomeRepoAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is HomeViewStateLoading -> handleLoadingState(binding)
                is HomeViewStateLoaded -> handleLoadedState(state, binding)
                is HomeViewStateError -> handleErrorState(state, binding)
            }

        })

        return binding.root
    }

    private fun handleErrorState(
        state: HomeViewStateError,
        binding: HomeScreenBinding
    ) {
        binding.progressBar.visibility = View.GONE
        binding.repoList.visibility = View.GONE
        binding.errorTextView.visibility = View.VISIBLE

        binding.errorTextView.text = state.message
    }

    private fun handleLoadedState(
        state: HomeViewStateLoaded,
        binding: HomeScreenBinding
    ) {
        binding.progressBar.visibility = View.GONE
        binding.repoList.visibility = View.VISIBLE
        binding.errorTextView.visibility = View.GONE
        (binding.repoList.adapter as HomeRepoAdapter).setRepoItems(state.repos)
    }

    private fun handleLoadingState(binding: HomeScreenBinding) {
        binding.progressBar.visibility = View.VISIBLE
        binding.repoList.visibility = View.GONE
        binding.errorTextView.visibility = View.GONE
    }
}