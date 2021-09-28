package com.example.navigationkt.guidefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import kotlinx.android.synthetic.main.fragment_guidefragment2.*
import kotlinx.android.synthetic.main.fragment_guidehomefragment.*

class guidefragment2 : Fragment() {

    lateinit var navController1 : NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guidefragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController1 = Navigation.findNavController(view)

        jump2.setOnClickListener {
            navController1.navigate(R.id.action_guidefragment2_to_guidefragment3)
        }
    }

}