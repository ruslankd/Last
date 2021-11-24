package com.example.last.presentation.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun repositories(userLogin: String): Screen
    fun repository(userLogin: String, reposName: String): Screen
}