package com.example.last.presentation.repository.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.last.presentation.GithubRepositoryViewModel

object RepositoryDiff : DiffUtil.ItemCallback<GithubRepositoryViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GithubRepositoryViewModel, newItem: GithubRepositoryViewModel): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GithubRepositoryViewModel, newItem: GithubRepositoryViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GithubRepositoryViewModel, newItem: GithubRepositoryViewModel) = payload

}