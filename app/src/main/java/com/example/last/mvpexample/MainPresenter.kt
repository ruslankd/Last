package com.example.last.mvpexample

class MainPresenter(
    private val view: MainView,
    private val model: CountersModel = CountersModel()
) {

    fun firstCounterClick() {
        view.setFirstCounterButtonText(model.next(0).toString())
    }

    fun secondCounterClick() {
        view.setSecondCounterButtonText(model.next(1).toString())
    }

    fun thirdCounterClick() {
        view.setThirdCounterButtonText(model.next(2).toString())
    }
}