package com.example.last.data.repository

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.last.data.user.GithubUser
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "github_repositories"
)
data class GithubRepository(
//    @Expose(serialize = false, deserialize = false)

    var login: String,
    @PrimaryKey
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("size")
    val size: Int
)