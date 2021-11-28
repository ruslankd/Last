package com.example.last.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_users")
data class GithubUser(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("login")
    val login: String,

    @SerializedName("name")
    val name: String?,

    @SerializedName("avatar_url")
    val avatar: String,

    @SerializedName("repos_url")
    val reposUrl: String
)