package com.example.last.data.user

import com.example.last.data.api.GithubApi
import com.example.last.data.api.GithubApiFactory
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GithubUserRepositoryImpl(
    private val gitHubApi: GithubApi = GithubApiFactory.create()
) : GithubUserRepository {

    override fun getUsers(): Single<List<GithubUser>> =
        gitHubApi
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GithubUser> =
        gitHubApi
            .fetchUserByLogin(userId)
            .onErrorComplete()

    override fun getUserRepositories(githubUser: GithubUser): Single<List<GithubRepository>> =
        gitHubApi.fetchRepositoriesByUrl(githubUser.reposUrl)

    override fun getRepositoryByLoginAndName(
        login: String,
        reposName: String
    ): Maybe<GithubRepository> =
        gitHubApi.fetchReposByLoginAndName(login, reposName).onErrorComplete()


}