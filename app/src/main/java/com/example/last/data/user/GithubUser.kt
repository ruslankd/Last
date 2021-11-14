package com.example.last.data.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubUser(
    val login: String
) : Parcelable