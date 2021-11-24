package com.example.last.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GithubUserRepository {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    override fun getUsers(): Single<List<GithubUser>> =
        Single.just(repositories)

    override fun getUserByLogin(userId: String): Maybe<GithubUser> =
        repositories.firstOrNull { user -> user.login == userId }
            ?.let { Maybe.just(it) }
            ?: Maybe.empty()
}