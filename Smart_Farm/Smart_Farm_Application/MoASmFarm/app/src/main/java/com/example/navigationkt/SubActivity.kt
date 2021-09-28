package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    lateinit var navController1 : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        navController1 = nav_fragment101.findNavController()

    }
}