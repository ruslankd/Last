package com.example.last.data.user.datasource

import com.example.last.data.api.GithubApi
import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GithubUserDataSourceImpl(private val githubApi: GithubApi) : GithubUserDataSource {
    override fun getUsers(): Single<List<GithubUser>> =
        githubApi
            .fetchUsers()

    override fun getUserByLogin(login: String): Maybe<GithubUser> =
        githubApi
            .fetchUserByLogin(login)
            .onErrorComplete()
}