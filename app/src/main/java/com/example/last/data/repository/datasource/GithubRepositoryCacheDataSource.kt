package com.example.last.data.repository.datasource

import com.example.last.data.repository.GithubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface GithubRepositoryCacheDataSource {
    fun getUserRepositories(login: String): Observable<List<GithubRepository>>
    fun getRepository(login: String, reposName: String): Observable<GithubRepository>
    fun retain(repositories: List<GithubRepository>): Completable
    fun retain(repository: GithubRepository): Completable
}