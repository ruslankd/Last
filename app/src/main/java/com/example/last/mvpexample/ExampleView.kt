package com.example.last.mvpexample

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ExampleView: MvpView {
    fun setFirstCounterButtonText(text: String)
    fun setSecondCounterButtonText(text: String)
    fun setThirdCounterButtonText(text: String)
}