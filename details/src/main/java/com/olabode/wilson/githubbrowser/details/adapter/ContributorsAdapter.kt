package com.olabode.wilson.githubbrowser.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.olabode.wilson.githubbrowser.details.databinding.ContributorItemBinding

/**
 *   Created by OLABODE WILSON on 8/26/20.
 */

class ContributorsAdapter : RecyclerView.Adapter<ContributorsAdapter.ContributorViewHolder>() {

    private val data: MutableList<ContributorItem> = mutableListOf()

    init {
        setHasStableIds(true)
    }

    fun setContributors(contributors: List<ContributorItem>) {
        data.clear()
        data.addAll(contributors)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val binding =
            ContributorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContributorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    override fun onBindViewHolder(holder: ContributorViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ContributorViewHolder(private val binding: ContributorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contributorItem: ContributorItem) {
            binding.contributorName.text = contributorItem.name
            binding.contributorAvatar.load(contributorItem.avatarUrl)
        }
    }
}
