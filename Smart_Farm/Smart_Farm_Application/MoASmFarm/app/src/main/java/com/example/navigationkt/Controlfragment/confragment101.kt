package com.example.navigationkt.Controlfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_102.*
import kotlinx.android.synthetic.main.fragment_confragment101.*

class confragment101 : Fragment() {

    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confragment101, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Firebase.database
        val myRef = database.getReference("back")

        myRef.setValue("1")

        navController = Navigation.findNavController(view)

        ledbtn.setOnClickListener {
            navController.navigate(R.id.action_confragment101_to_confragment201)

        }

        pumpbtn.setOnClickListener {
            navController.navigate(R.id.action_confragment101_to_confragment202)

        }

        fanbtn.setOnClickListener {
            navController.navigate(R.id.action_confragment101_to_confragment203)

        }
    }


}