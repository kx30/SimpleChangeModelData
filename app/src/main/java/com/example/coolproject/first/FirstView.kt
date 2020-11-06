package com.example.coolproject.first

import com.example.coolproject.CoolModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface FirstView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateCoolTextView(name: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openSecondFragment(someCoolModel: CoolModel)
}