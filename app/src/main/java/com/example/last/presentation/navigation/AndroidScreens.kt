package com.example.last.presentation.navigation

import com.example.last.view.UserFragment
import com.example.last.view.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(userLogin: String) = FragmentScreen { UserFragment.newInstance(userLogin) }
}