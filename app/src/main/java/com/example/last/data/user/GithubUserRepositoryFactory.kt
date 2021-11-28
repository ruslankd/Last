package com.example.last.data.user

object GithubUserRepositoryFactory {

    fun create(): GithubUserRepository = GithubUserRepositoryImpl()

}