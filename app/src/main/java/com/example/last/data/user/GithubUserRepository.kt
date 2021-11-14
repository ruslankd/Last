package com.example.last.data.user

interface GithubUserRepository {
    fun getUsers(): List<GithubUser>

    fun getUserByLogin(userId: String): GithubUser?
}