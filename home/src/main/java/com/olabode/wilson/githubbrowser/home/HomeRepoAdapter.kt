package com.olabode.wilson.githubbrowser.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.githubbrowser.home.databinding.RepoItemBinding
import com.olabode.wilson.githubbrowser.home.model.RepoItem

/**
 *   Created by OLABODE WILSON on 8/25/20.
 */


class HomeRepoAdapter : RecyclerView.Adapter<HomeRepoAdapter.RepoItemViewHolder>() {

    private val data: MutableList<RepoItem> = mutableListOf()

    fun setRepoItems(repoItems: List<RepoItem>) {
        data.clear()
        data.addAll(repoItems)
        notifyDataSetChanged()
    }

    class RepoItemViewHolder(private val binding: RepoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repoItem: RepoItem) {
            with(repoItem) {
                binding.repoName.text = name
                binding.description.text = description
                binding.stars.text = starsCount
                binding.forks.text = forksCount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val binding = RepoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepoItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(data[position])
    }
}