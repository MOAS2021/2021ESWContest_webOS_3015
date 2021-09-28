package com.example.navigationkt.sub7fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationkt.*
import kotlinx.android.synthetic.main.fragment_101.*
import kotlinx.android.synthetic.main.fragment_701.*

class Fragment701 : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_701, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seed1.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity1::class.java)
            startActivity(intent)
        }
        seed2.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity2::class.java)
            startActivity(intent)
        }
        seed3.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity3::class.java)
            startActivity(intent)
        }
        seed4.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity4::class.java)
            startActivity(intent)
        }
        seed5.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity5::class.java)
            startActivity(intent)
        }
        seed6.setOnClickListener {
            val intent = Intent(getActivity(), shopActivity6::class.java)
            startActivity(intent)
        }

    }

}