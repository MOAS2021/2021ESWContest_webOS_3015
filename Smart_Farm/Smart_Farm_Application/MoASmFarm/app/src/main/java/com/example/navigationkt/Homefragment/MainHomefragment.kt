package com.example.navigationkt.Homefragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationkt.*
import com.example.navigationkt.databinding.FragmentMainHomefragmentBinding
import kotlinx.android.synthetic.main.fragment_701.*
import kotlinx.android.synthetic.main.fragment_main_homefragment.*

class MainHomefragment : Fragment() {

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : MainHomefragment{
            return MainHomefragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_homefragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_main1.setOnClickListener {
            val intent = Intent(getActivity(), HomeFirstActivity1::class.java)
            startActivity(intent)
        }

        btn_main2.setOnClickListener {
            val intent = Intent(getActivity(), HomeSecondActivity::class.java)
            startActivity(intent)
        }

        btn_main3.setOnClickListener {
            val intent = Intent(getActivity(), HomeThirdActivity::class.java)
            startActivity(intent)
        }
    }



}