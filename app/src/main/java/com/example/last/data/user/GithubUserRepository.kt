package com.example.last.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GithubUserRepository {
    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(userId: String): Maybe<GithubUser>
}