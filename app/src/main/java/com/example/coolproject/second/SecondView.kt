package com.example.coolproject.second

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SecondView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun returnToPreviousFragment()
}