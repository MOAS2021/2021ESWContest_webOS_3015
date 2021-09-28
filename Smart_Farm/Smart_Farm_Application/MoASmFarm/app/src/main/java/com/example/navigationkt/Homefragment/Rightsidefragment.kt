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
import kotlinx.android.synthetic.main.fragment_main_homefragment.*
import kotlinx.android.synthetic.main.fragment_main_homefragment.btn_main1
import kotlinx.android.synthetic.main.fragment_rightsidefragment.*

class Rightsidefragment : Fragment() {

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : Rightsidefragment{
            return Rightsidefragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Right")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rightsidefragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setting1.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity1::class.java)
            startActivity(intent)
        }
        setting2.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity2::class.java)
            startActivity(intent)
        }
        setting3.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity3::class.java)
            startActivity(intent)
        }
        setting4.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity4::class.java)
            startActivity(intent)
        }
        setting5.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity5::class.java)
            startActivity(intent)
        }
        setting6.setOnClickListener {
            val intent = Intent(getActivity(), SettingActivity6::class.java)
            startActivity(intent)
        }


    }

}