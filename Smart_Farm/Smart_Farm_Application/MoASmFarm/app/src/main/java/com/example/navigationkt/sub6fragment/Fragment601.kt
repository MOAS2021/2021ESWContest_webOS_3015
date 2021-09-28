package com.example.navigationkt.sub6fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.R
import kotlinx.android.synthetic.main.activity_home_first1.*
import kotlinx.android.synthetic.main.fragment_101.*
import kotlinx.android.synthetic.main.fragment_601.*
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

class Fragment601 : Fragment() {

    lateinit var navController6 : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_601, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController6 = Navigation.findNavController(view)

        btn_library1.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment611)
        }
        btn_library2.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment612)
        }
        btn_library3.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment613)
        }
        btn_library4.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment614)
        }
        btn_library5.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment615)
        }
        btn_library6.setOnClickListener {
            navController6.navigate(R.id.action_fragment601_to_fragment616)
        }
    }



}