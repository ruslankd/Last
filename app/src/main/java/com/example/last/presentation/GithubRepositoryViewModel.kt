package com.example.last.presentation

import com.example.last.data.user.GithubRepository

data class GithubRepositoryViewModel(
    val name: String,
    val forksCount: Int
) {

    object Mapper {

        fun map(repository: GithubRepository) =
            GithubRepositoryViewModel(
                repository.name,
                repository.forksCount
            )

    }

}
