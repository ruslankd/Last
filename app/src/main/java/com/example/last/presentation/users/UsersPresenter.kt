package com.example.last.presentation.users

import com.example.last.data.user.GithubUser
import com.example.last.data.user.GithubUserRepositoryImpl
import com.example.last.presentation.navigation.AndroidScreens
import com.example.last.presentation.users.adapter.IUserListPresenter
import com.example.last.presentation.users.adapter.UserItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUserRepositoryImpl, val router: Router) :
    MvpPresenter<UsersView>() {
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
            router.navigateTo(
                AndroidScreens().repositories(
                    usersListPresenter.users[itemView.pos].login
                )
            )
        }
    }

    fun loadData() {
        disposable = usersRepo.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe { users ->
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