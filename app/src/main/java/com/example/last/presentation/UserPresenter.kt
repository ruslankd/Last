package com.example.last.presentation

import com.example.last.data.user.GithubUserRepository
import com.example.last.view.UserView
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GithubUserRepository
) : MvpPresenter<UserView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        disposable = userRepository
            .getUserByLogin(userLogin)
            .subscribe(
                { user -> viewState.showUser(user)},
                { error -> viewState.showError(error)},
                { viewState.showEmpty()}
            )
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }

}