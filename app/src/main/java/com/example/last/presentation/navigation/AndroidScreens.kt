package com.example.last.presentation.navigation

import com.example.last.presentation.reposinfo.ReposInfoFragment
import com.example.last.presentation.repository.RepositoriesFragment
import com.example.last.presentation.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun repositories(userLogin: String) =
        FragmentScreen { RepositoriesFragment.newInstance(userLogin) }

    override fun repository(userLogin: String, reposName: String) =
        FragmentScreen { ReposInfoFragment.newInstance(userLogin, reposName) }
}