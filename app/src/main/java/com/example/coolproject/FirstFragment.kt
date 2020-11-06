package com.example.coolproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private lateinit var someCoolModel: CoolModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        someCoolModel = arguments?.getSerializable("CoolModel") as CoolModel
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        coolModelNameTextView.text = someCoolModel.name
    }

    private fun setListeners() {
        coolModelNameTextView.setOnClickListener {
            openSecondFragment()
        }
    }

    private fun openSecondFragment() {
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
}