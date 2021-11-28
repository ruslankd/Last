package com.example.last.data.storage

import androidx.room.Room
import com.example.last.presentation.App.ContextHolder.context

object GithubStorageFactory {

    private val database: GithubStorage by lazy {
        Room.databaseBuilder(context, GithubStorage::class.java, "github.db")
            .build()
    }

    fun create(): GithubStorage = database
}