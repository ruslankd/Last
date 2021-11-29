package com.example.last.data.user.datasource

import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubUserCacheDataSource {
    fun getUsers(): Observable<List<GithubUser>>
    fun getUserByLogin(login: String): Observable<GithubUser>
    fun retain(users: List<GithubUser>): Observable<List<GithubUser>>
    fun retain(user: GithubUser): Single<GithubUser>
}