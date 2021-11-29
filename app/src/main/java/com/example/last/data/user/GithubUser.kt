package com.example.last.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_users")
data class GithubUser(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo
    @SerializedName("login")
    val login: String,

    @ColumnInfo
    @SerializedName("name")
    val name: String?,

    @ColumnInfo
    @SerializedName("avatar_url")
    val avatar: String
)