package com.example.last.presentation.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.last.R
import com.example.last.databinding.ItemRepositoryBinding
import com.example.last.presentation.GithubRepositoryViewModel

class RepositoriesAdapter(private val delegate: Delegate?): ListAdapter<GithubRepositoryViewModel, RepositoryViewHolder>(RepositoryDiff) {

    interface Delegate {

        fun onRepositoryPicked(repository: GithubRepositoryViewModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}