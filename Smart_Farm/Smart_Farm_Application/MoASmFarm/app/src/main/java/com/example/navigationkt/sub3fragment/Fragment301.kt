package com.example.navigationkt.sub3fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import kotlinx.android.synthetic.main.fragment_101.*
import kotlinx.android.synthetic.main.fragment_301.*

class Fragment301 : Fragment() {

    lateinit var navController1 : NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_301, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController1 = Navigation.findNavController(view)

        btnnext_301_310.setOnClickListener {
            navController1.navigate(R.id.action_fragment301_to_fragment310)
        }
    }

}