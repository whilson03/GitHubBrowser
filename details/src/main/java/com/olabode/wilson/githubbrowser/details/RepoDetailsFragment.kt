package com.olabode.wilson.githubbrowser.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.olabode.wilson.githubbrowser.details.databinding.ScreenDetailsBinding
import com.olabode.wilson.githubbrowser.di.viewmodel.AppViewModelFactory
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */


class RepoDetailsFragment : Fragment() {

    companion object {
        fun newInstance(repoOwner: String, repoName: String): RepoDetailsFragment {
            val args = Bundle().apply {
                putString("repo_name", repoName)
                putString("repo_owner", repoOwner)
            }
            return RepoDetailsFragment().apply { arguments = args }
        }
    }


    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[RepoDetailsViewModel::class.java]
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
        val binding = ScreenDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }
}