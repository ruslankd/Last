package com.example.last.data.user.datasource

import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(login: String): Maybe<GithubUser>
}