package com.example.last.data.user

import com.google.gson.annotations.SerializedName

data class GithubUser(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("type")
    val type: Type
) {

    enum class Type {
        @SerializedName("User")
        USER,
        @SerializedName("Admin")
        ADMINISTRATOR,
        UNKNOWN
    }

}