package com.example.last.data.user

import com.example.last.data.api.GithubApiFactory
import com.example.last.data.repository.datasource.GithubRepositoryCacheDataSourceImpl
import com.example.last.data.repository.datasource.GithubRepositoryDataSourceImpl
import com.example.last.data.storage.GithubStorageFactory
import com.example.last.data.user.datasource.GithubUserCacheDataSourceImpl
import com.example.last.data.user.datasource.GithubUserDataSourceImpl

object GithubUserRepositoryFactory {

    private val gitHubUserRepository: GithubUserRepository by lazy {
        GithubUserRepositoryImpl(
            GithubUserDataSourceImpl(
                GithubApiFactory.create()
            ),
            GithubUserCacheDataSourceImpl(
                GithubStorageFactory.create()
            ),
            GithubRepositoryDataSourceImpl(
                GithubApiFactory.create()
            ),
            GithubRepositoryCacheDataSourceImpl(
                GithubStorageFactory.create()
            )
        )
    }

    fun create(): GithubUserRepository = gitHubUserRepository

}