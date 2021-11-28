package com.example.last.data.api

import com.example.last.data.user.GithubRepository
import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GithubApi {
    @GET("/users")
    fun fetchUsers(): Single<List<GithubUser>>

    @GET("/users/{login}")
    fun fetchUserByLogin(@Path("login") login: String): Single<GithubUser>

    @GET
    fun fetchRepositoriesByUrl(@Url url: String): Single<List<GithubRepository>>

    @GET("/repos/{owner}/{repo}")
    fun fetchReposByLoginAndName(
        @Path("owner") login: String,
        @Path("repo") reposName: String
    ): Single<GithubRepository>
}