package com.example.last.data.user

import com.example.last.data.repository.GithubRepository
import com.example.last.data.repository.datasource.GithubRepositoryCacheDataSource
import com.example.last.data.repository.datasource.GithubRepositoryDataSource
import com.example.last.data.user.datasource.GithubUserCacheDataSource
import com.example.last.data.user.datasource.GithubUserDataSource
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

class GithubUserRepositoryImpl(
    private val githubUserDataSource: GithubUserDataSource,
    private val githubUserCacheDataSource: GithubUserCacheDataSource,
    private val githubRepositoryDataSource: GithubRepositoryDataSource,
    private val githubRepositoryCacheDataSource: GithubRepositoryCacheDataSource,
) : GithubUserRepository {

    override fun getUsers(): Observable<List<GithubUser>> {
//        return githubUserDataSource
//            .getUsers()
//            .doOnSuccess(githubUserCacheDataSource::retain)
//            .onErrorReturn { githubUserCacheDataSource.getUsers().blockingFirst() }
//            .toObservable()
        return Observable.merge(
            githubUserCacheDataSource
                .getUsers(),
            githubUserDataSource
                .getUsers()
                .flatMapObservable(githubUserCacheDataSource::retain)
        )
    }

    override fun getUserByLogin(login: String): Observable<GithubUser> =
        Observable.merge(
            githubUserCacheDataSource
                .getUserByLogin(login),
            githubUserDataSource
                .getUserByLogin(login)
                .flatMapCompletable { user ->
                    githubUserCacheDataSource
                        .retain(user)
                        .flatMapCompletable {
                            githubRepositoryDataSource
                                .getUserRepositories(user.login)
                                .map { repositories ->
                                    repositories
                                        .map { repository ->
                                            repository.copy(login = user.login)
                                        }
                                }
                                .flatMapCompletable(githubRepositoryCacheDataSource::retain)
                        }
                }
                .toObservable()
        )

    override fun getUserRepositories(login: String): Observable<List<GithubRepository>> =
        Observable.merge(
            githubRepositoryCacheDataSource
                .getUserRepositories(login),
            githubRepositoryDataSource
                .getUserRepositories(login)
                .map { repositories -> repositories.map { repository -> repository.copy(login = login) }}
                .flatMapCompletable(githubRepositoryCacheDataSource::retain)
                .toObservable()
        )

    override fun getRepositoryByLoginAndName(
        login: String,
        reposName: String
    ): Observable<GithubRepository> =
        Observable.merge(
            githubRepositoryCacheDataSource
                .getRepository(login, reposName),
            githubRepositoryDataSource
                .getRepository(login, reposName)
                .flatMapCompletable(githubRepositoryCacheDataSource::retain)
                .toObservable()
        )


}