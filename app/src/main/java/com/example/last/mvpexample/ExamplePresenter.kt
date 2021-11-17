package com.example.last.mvpexample

import moxy.MvpPresenter

class ExamplePresenter(
    private val model: CountersModel
) : MvpPresenter<ExampleView>() {

    fun firstCounterClick() {
        viewState.setFirstCounterButtonText(model.next(0).toString())
    }

    fun secondCounterClick() {
        viewState.setSecondCounterButtonText(model.next(1).toString())
    }

    fun thirdCounterClick() {
        viewState.setThirdCounterButtonText(model.next(2).toString())
    }
}