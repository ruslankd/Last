package com.example.last.data.repository.datasource

import com.example.last.data.repository.GithubRepository
import com.example.last.data.storage.GithubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubRepositoryCacheDataSourceImpl(private val githubStorage: GithubStorage) :
    GithubRepositoryCacheDataSource {

    override fun getUserRepositories(login: String): Observable<List<GithubRepository>> =
        githubStorage.getGitHubRepositoryDao().getRepositoriesByLogin(login)

    override fun getRepository(login: String, reposName: String): Observable<GithubRepository> =
        githubStorage.getGitHubRepositoryDao().getRepositoryByLoginAndName(login, reposName)

    override fun retain(repositories: List<GithubRepository>): Completable =
        githubStorage.getGitHubRepositoryDao().retain(repositories)

    override fun retain(repository: GithubRepository): Completable =
        githubStorage.getGitHubRepositoryDao().retain(repository)
}