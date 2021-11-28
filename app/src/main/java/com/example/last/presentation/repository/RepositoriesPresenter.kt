package com.example.last.presentation.repository

import com.example.last.data.user.GithubUserRepository
import com.example.last.presentation.GithubRepositoryViewModel
import com.example.last.presentation.navigation.AndroidScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter(
    private val userLogin: String,
    private val userRepository: GithubUserRepository,
    private val router: Router
) : MvpPresenter<RepositoriesView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        disposable = userRepository
            .getUserByLogin(userLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { user ->
                    userRepository
                        .getUserRepositories(user)
                        .observeOn(Schedulers.newThread())
                        .map { repositories -> repositories.map(GithubRepositoryViewModel.Mapper::map) }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(
                            viewState::showRepositories
                        )
                },
                { error -> viewState.showError(error) },
                { viewState.showEmpty() }
            )
    }

    fun displayRepository(repository: GithubRepositoryViewModel) {
        router.navigateTo(AndroidScreens().repository(userLogin, repository.name))
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

}