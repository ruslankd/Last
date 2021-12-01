package com.example.last.presentation.main

import android.os.Bundle
import com.example.last.presentation.App
import com.example.last.R
import com.example.last.databinding.ActivityMainBinding
import com.example.last.presentation.navigation.AndroidScreens
import com.example.last.presentation.BackButtonListener
import com.example.last.presentation.abs.AbsActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : AbsActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var androidScreens: AndroidScreens

    private val presenter by moxyPresenter { MainPresenter(router, androidScreens) }
    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}