package com.example.last.presentation.reposinfo

import com.example.last.data.user.GithubRepository
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ReposInfoView : MvpView {
    fun showInfo(repository: GithubRepository)
    fun showError(error: Throwable)
    fun showEmpty()
}