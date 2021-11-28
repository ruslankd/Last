package com.example.last.data.user.datasource

import com.example.last.data.storage.GithubStorage
import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUserCacheDataSourceImpl(
    private val githubStorage: GithubStorage
) : GithubUserCacheDataSource {

    override fun getUsers(): Observable<List<GithubUser>> =
        githubStorage.getGitHubUserDao().getUsers()

    override fun getUserByLogin(login: String): Observable<GithubUser> =
        githubStorage.getGitHubUserDao().getUserByLogin(login)

    override fun retain(users: List<GithubUser>): Observable<List<GithubUser>> =
        githubStorage
            .getGitHubUserDao()
            .retain(users)
            .andThen(
                githubStorage
                    .getGitHubUserDao()
                    .getUsers()
            )

    override fun retain(user: GithubUser): Single<GithubUser> =
        githubStorage
            .getGitHubUserDao()
            .retain(user)
            .andThen(
                githubStorage
                    .getGitHubUserDao()
                    .getUserByLogin(user.login)
                    .firstOrError()
            )
}