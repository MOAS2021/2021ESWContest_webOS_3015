package com.example.navigationkt.sub1fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import kotlinx.android.synthetic.main.fragment_101.*


class Fragment101 : Fragment() {
    lateinit var navController1 : NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_101, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController1 = Navigation.findNavController(view)

        btn_next101_102.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment102)
        }
        btn_next101_112.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment112)
        }
        btn_next101_122.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment122)
        }
        btn_next101_132.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment132)
        }
        btn_next101_142.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment142)
        }
        btn_next101_152.setOnClickListener {
            navController1.navigate(R.id.action_fragment101_to_fragment152)
        }
    }
}