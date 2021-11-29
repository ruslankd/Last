package com.example.last.data.repository.datasource

import com.example.last.data.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

interface GithubRepositoryDataSource {
    fun getUserRepositories(login: String): Single<List<GithubRepository>>
    fun getRepository(login: String, reposName: String): Single<GithubRepository>
}