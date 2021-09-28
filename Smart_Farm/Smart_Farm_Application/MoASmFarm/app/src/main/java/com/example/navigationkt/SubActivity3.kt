package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_sub.*
import kotlinx.android.synthetic.main.activity_sub3.*
import kotlinx.android.synthetic.main.activity_sub3.view.*


class SubActivity3 : AppCompatActivity() {

    lateinit var navController1 : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub3)

        navController1 = nav_fragment301.findNavController()

    }

}
