package com.example.last.data.user

import com.google.gson.annotations.SerializedName

data class GithubRepository(
    @SerializedName("name")
    val name: String,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("size")
    val size: Int
)