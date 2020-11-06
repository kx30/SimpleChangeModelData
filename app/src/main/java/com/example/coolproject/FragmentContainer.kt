package com.example.coolproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coolproject.first.FirstFragment

class FragmentContainer: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            val fragment = FirstFragment()
            val bundle = Bundle()
            bundle.putSerializable("CoolModel", CoolModel(1, "Sobaka"))
            fragment.arguments = bundle
            fragmentManager
                ?.beginTransaction()
                ?.add(R.id.fragmentContainer, fragment)
                ?.commit()
        }
    }
}