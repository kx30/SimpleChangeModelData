package com.example.coolproject.first

import com.example.coolproject.CoolModel
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstPresenter : MvpPresenter<FirstView>() {

    lateinit var someCoolModel: CoolModel

    fun onViewResume() {
        viewState.updateCoolTextView(someCoolModel.name)
    }

    fun onCoolModelNameTextViewClicked() {
        viewState.openSecondFragment(someCoolModel)
    }
}