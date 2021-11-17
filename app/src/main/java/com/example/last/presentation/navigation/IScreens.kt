package com.example.last.presentation.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(userLogin: String): Screen
}