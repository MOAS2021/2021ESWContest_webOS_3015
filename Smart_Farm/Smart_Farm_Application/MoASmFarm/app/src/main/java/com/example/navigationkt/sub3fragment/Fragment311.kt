package com.example.navigationkt.sub3fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationkt.HomeFirstActivity1
import com.example.navigationkt.MainActivity
import com.example.navigationkt.R
import kotlinx.android.synthetic.main.fragment_311.*
import kotlinx.android.synthetic.main.fragment_main_homefragment.*

class Fragment311 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_311, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home1.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }
}