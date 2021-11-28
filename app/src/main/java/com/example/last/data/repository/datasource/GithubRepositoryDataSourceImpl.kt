package com.example.last.data.repository.datasource

import com.example.last.data.api.GithubApi
import com.example.last.data.repository.GithubRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubRepositoryDataSourceImpl(private val githubApi: GithubApi) :
    GithubRepositoryDataSource {
    override fun getUserRepositories(login: String): Single<List<GithubRepository>> =
        githubApi
            .fetchUserRepositories(login)

    override fun getRepository(login: String, reposName: String): Single<GithubRepository> =
        githubApi
            .fetchReposByLoginAndName(login, reposName)
}