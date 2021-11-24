package com.example.last.presentation

import com.example.last.data.user.GithubUser
import com.example.last.data.user.GitHubUserRepositoryImpl
import com.example.last.presentation.navigation.AndroidScreens
import com.example.last.presentation.users.adapter.IUserListPresenter
import com.example.last.presentation.users.adapter.UserItemView
import com.example.last.view.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GitHubUserRepositoryImpl, val router: Router) : MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(AndroidScreens().user(
                usersListPresenter.users[itemView.pos].login
            ))
        }
    }

    fun loadData() {
        disposable = usersRepo.getUsers().subscribe { users ->
            usersListPresenter.users.addAll(users)
            viewState.updateList()
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }

}