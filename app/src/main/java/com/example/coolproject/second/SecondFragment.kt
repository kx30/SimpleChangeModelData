package com.example.coolproject.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coolproject.CoolModel
import com.example.coolproject.R
import kotlinx.android.synthetic.main.fragment_second.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SecondFragment : MvpAppCompatFragment(), SecondView {

    @InjectPresenter
    lateinit var presenter: SecondPresenter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        button.setOnClickListener {
            presenter.onButtonClicked()
        }
    }

    override fun returnToPreviousFragment() {
        val someCoolModel = arguments?.getSerializable("CoolModel") as CoolModel
        someCoolModel.name = "cat"

        fragmentManager?.popBackStack()
    }
}