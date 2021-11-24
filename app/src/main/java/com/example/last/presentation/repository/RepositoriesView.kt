package com.example.last.presentation.repository

import com.example.last.presentation.GithubRepositoryViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoriesView : MvpView {
    fun showRepositories(repositories: List<GithubRepositoryViewModel>)
    fun showEmpty()
    fun showError(error: Throwable)
}