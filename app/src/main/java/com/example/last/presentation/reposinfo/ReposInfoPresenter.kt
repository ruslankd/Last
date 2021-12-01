package com.example.last.presentation.reposinfo

import com.example.last.data.user.GithubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposInfoPresenter(
    private val userLogin: String,
    private val reposName: String,
    private val userRepo: GithubUserRepository
) : MvpPresenter<ReposInfoView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        disposable = userRepo
            .getRepositoryByLoginAndName(userLogin, reposName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { repository ->
                    viewState.showInfo(repository)
                },
                { error -> viewState.showError(error) },
                { viewState.showEmpty() }
            )
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }
}