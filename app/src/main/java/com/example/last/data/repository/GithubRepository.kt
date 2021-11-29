package com.example.last.data.repository

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
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

    @ColumnInfo
    var login: String?,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    var id: Int,

    @ColumnInfo
    @SerializedName("name")
    val name: String,
    @ColumnInfo
    @SerializedName("forks_count")
    val forksCount: Int,
    @ColumnInfo
    @SerializedName("description")
    val description: String?,
    @ColumnInfo
    @SerializedName("size")
    val size: Int
)