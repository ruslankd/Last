package com.example.last.data.user

import com.example.last.data.repository.GithubRepository
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface GithubUserRepository {
    fun getUsers(): Observable<List<GithubUser>>

    fun getUserByLogin(login: String): Observable<GithubUser>

    fun getUserRepositories(login: String): Observable<List<GithubRepository>>

    fun getRepositoryByLoginAndName(login: String, reposName: String): Observable<GithubRepository>
}