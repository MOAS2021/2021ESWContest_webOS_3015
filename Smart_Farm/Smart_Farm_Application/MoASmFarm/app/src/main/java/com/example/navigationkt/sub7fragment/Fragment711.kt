package com.example.navigationkt.sub7fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import com.example.navigationkt.SubActivity7
import com.example.navigationkt.shopActivity1
import kotlinx.android.synthetic.main.fragment_101.*
import kotlinx.android.synthetic.main.fragment_711.*

class Fragment711 : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_711, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        buybtn1.setOnClickListener {
            navController.navigate(R.id.action_fragment711_to_shopFragment101)
        }

        shophome.setOnClickListener {
            val intent = Intent(getActivity(), SubActivity7::class.java)
            startActivity(intent)
        }
    }

}