package com.example.last.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.last.data.repository.GithubRepository
import com.example.last.data.user.GithubUser

@Database(
    exportSchema = false,
    entities = [GithubUser::class, GithubRepository::class],
    version = 1,
)
abstract class GithubStorage : RoomDatabase() {
    abstract fun getGitHubUserDao(): GithubUserDao
    abstract fun getGitHubRepositoryDao(): GithubRepositoryDao
}