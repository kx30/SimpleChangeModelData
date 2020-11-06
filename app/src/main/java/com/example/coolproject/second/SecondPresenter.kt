package com.example.coolproject.second

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SecondPresenter: MvpPresenter<SecondView>() {

    fun onButtonClicked() {
        viewState.returnToPreviousFragment()
    }
}