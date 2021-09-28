package com.example.navigationkt.sub1fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_102.*
import kotlinx.android.synthetic.main.fragment_112.*

class Fragment112 : Fragment() {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_112, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        navController = Navigation.findNavController(view)

        yesbtn2.setOnClickListener {
            navController.navigate(R.id.action_fragment112_to_fragment113)
        }

        yesbtn2_1.setOnClickListener {
            navController.navigate(R.id.action_fragment112_to_fragment114)
        }


    }

}