package com.example.navigationkt.Homefragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationkt.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment_201.*
import kotlinx.android.synthetic.main.fragment_201.temtext
import kotlinx.android.synthetic.main.fragment_leftsidefragment.*


class Leftsidefragment : Fragment() {





    companion object{
        const val TAG : String = "로그"

        fun newInstance() : Leftsidefragment{
            return Leftsidefragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Left")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leftsidefragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Firebase.database

        val myRef1 = database.getReference("plantname")

        myRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var A = dataSnapshot.getValue<String>()
                textView8.setText(A)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        val myRef2 = database.getReference("ymd")

        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var B = dataSnapshot.getValue<String>()
                textView11.setText(B)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })


    }



}