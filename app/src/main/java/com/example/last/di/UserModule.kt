package com.example.last.di

import com.example.last.data.user.GithubUserRepository
import com.example.last.data.user.GithubUserRepositoryImpl
import com.example.last.presentation.main.MainActivity
import com.example.last.presentation.reposinfo.ReposInfoFragment
import com.example.last.presentation.repository.RepositoriesFragment
import com.example.last.presentation.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
interface UserModule {

    @ContributesAndroidInjector
    fun bindMainFragment(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindRepositoriesFragment(): RepositoriesFragment

    @ContributesAndroidInjector
    fun bindReposInfoFragment(): ReposInfoFragment

    @Singleton
    @Binds
    fun bindGitHubUserRepository(
        gitHubUserRepository: GithubUserRepositoryImpl
    ): GithubUserRepository

}