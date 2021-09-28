package com.example.navigationkt.sub1fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_102.*
import kotlinx.android.synthetic.main.fragment_132.*


class Fragment132 : Fragment() {
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_132, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        navController = Navigation.findNavController(view)

        yesbtn4.setOnClickListener {
            navController.navigate(R.id.action_fragment132_to_fragment133)
        }

        yesbtn4_1.setOnClickListener {
            navController.navigate(R.id.action_fragment132_to_fragment134)
        }


    }





}


