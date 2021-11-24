package com.example.last.presentation.repository.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.last.databinding.ItemRepositoryBinding
import com.example.last.presentation.GithubRepositoryViewModel

class RepositoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val viewBinding = ItemRepositoryBinding.bind(view)


    fun bind(repositoryModel: GithubRepositoryViewModel, delegate: RepositoriesAdapter.Delegate?) {
        with(viewBinding) {
            tvRepository.text = repositoryModel.name

            root.setOnClickListener { delegate?.onRepositoryPicked(repositoryModel) }
        }
    }

}