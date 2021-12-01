package com.example.last.data.user

import com.example.last.data.api.GithubApi
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUserRepositoryImpl
    @Inject constructor(private val gitHubApi: GithubApi)
 : GithubUserRepository {

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