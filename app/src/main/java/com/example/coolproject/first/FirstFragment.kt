package com.example.coolproject.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coolproject.CoolModel
import com.example.coolproject.R
import com.example.coolproject.second.SecondFragment
import kotlinx.android.synthetic.main.fragment_first.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class FirstFragment : MvpAppCompatFragment(), FirstView {

    @InjectPresenter
    lateinit var presenter: FirstPresenter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.someCoolModel = arguments?.getSerializable("CoolModel") as CoolModel
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewResume()
    }

    override fun updateCoolTextView(name: String) {
        coolModelNameTextView.text = name
    }

    override fun openSecondFragment(someCoolModel: CoolModel) {
        val fragment = SecondFragment()
        val bundle = Bundle()
        bundle.putSerializable("CoolModel", someCoolModel)
        fragment.arguments = bundle

        fragmentManager
            ?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.fragmentContainer, fragment)
            ?.commit()
    }

    private fun setListeners() {
        coolModelNameTextView.setOnClickListener {
            presenter.onCoolModelNameTextViewClicked()
        }
    }
}