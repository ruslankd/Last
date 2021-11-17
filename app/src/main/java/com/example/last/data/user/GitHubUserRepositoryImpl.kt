package com.example.last.data.user

import com.example.last.data.user.GithubUser

class GitHubUserRepositoryImpl : GithubUserRepository {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    override fun getUsers() : List<GithubUser> {
        return repositories
    }

    override fun getUserByLogin(userId: String): GithubUser? =
        repositories.firstOrNull { user -> user.login == userId }
}