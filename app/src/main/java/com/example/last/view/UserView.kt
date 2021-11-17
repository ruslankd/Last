package com.example.last.view

import com.example.last.data.user.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun showUser(user: GithubUser)
    fun showError(error: Throwable)
    fun showEmpty()
}