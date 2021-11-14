package com.example.last.data.user

object GitHubUserRepositoryFactory {

    fun create(): GithubUserRepository = GitHubUserRepositoryImpl()

}